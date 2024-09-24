package pl.nn.exchange.domain.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nn.exchange.domain.exchange.model.CurrencyCode;
import pl.nn.exchange.domain.exchange.model.ExchangeQuery;
import pl.nn.exchange.domain.exchange.model.ExchangeQueryResult;
import pl.nn.exchange.domain.exchange.model.GetExchangeRateResult;
import pl.nn.exchange.domain.in.ExchangeUseCase;
import pl.nn.exchange.external.nbp.NbpRestApiClient;
import pl.nn.exchange.external.storage.AccountRepository;
import pl.nn.exchange.external.storage.model.Account;
import pl.nn.exchange.external.storage.model.Wallet;
import pl.nn.exchange.infrastructure.exception.AccountNotFoundException;
import pl.nn.exchange.infrastructure.exception.BusinessValidationException;
import pl.nn.exchange.infrastructure.exception.WalletNotFoundException;

import java.math.BigDecimal;

import static pl.nn.exchange.infrastructure.config.BigDecimalConst.ROUNDING_MODE;
import static pl.nn.exchange.infrastructure.config.BigDecimalConst.SCALE;

@Component
@RequiredArgsConstructor
class ExchangeHandler implements ExchangeUseCase {

    private final NbpRestApiClient nbpRestApiClient;
    private final AccountRepository accountRepository;
    private final ExchangeMapper mapper;
    private final ExchangeQueryValidator validator;

    @Override
    public GetExchangeRateResult getExchangeRate(CurrencyCode currencyCode) {
        var response = nbpRestApiClient.getExchangeRate(mapper.map(currencyCode));
        return mapper.map(response);
    }

    @Override
    public ExchangeQueryResult exchange(ExchangeQuery query) {
        validator.validate(query);
        var account = accountRepository
                .get(query.accountId())
                .orElseThrow(() -> new AccountNotFoundException(query.accountId()));

        var walletFrom = getWalletByCurrency(account, mapper.map(query.from()));
        var walletTo = getWalletByCurrency(account, mapper.map(query.to()));

        var usdRate = nbpRestApiClient.getUsdRate();
        BigDecimal amountToExchange;
        if (Wallet.Currency.USD.equals(walletTo.getCurrency())) {
            amountToExchange = query.amount().divide(usdRate.ask(), SCALE, ROUNDING_MODE);
        } else {
            amountToExchange = query.amount().multiply(usdRate.bid());
        }

        var isBalanceAfterExchangeGtZero = BigDecimal.ZERO.compareTo(walletFrom.getAmount().subtract(query.amount())) <= 0;
        if (!isBalanceAfterExchangeGtZero) {
            throw new BusinessValidationException("Balance after exchange can't lest than zero.");
        }

        exchange(walletFrom, walletTo, query.amount(), amountToExchange);

        return mapper.map(accountRepository.save(account));
    }

    private void exchange(Wallet from, Wallet to, BigDecimal amount, BigDecimal amountToExchange) {
        from.setAmount(from.getAmount().subtract(amount).setScale(SCALE, ROUNDING_MODE));
        to.setAmount(to.getAmount().add(amountToExchange).setScale(SCALE, ROUNDING_MODE));
    }

    private Wallet getWalletByCurrency(Account account, Wallet.Currency currency) {
        return account.getWallets()
                .stream()
                .filter(w -> currency.equals(w.getCurrency()))
                .findFirst()
                .orElseThrow(() -> new WalletNotFoundException(account.getId(), currency.name()));
    }
}
