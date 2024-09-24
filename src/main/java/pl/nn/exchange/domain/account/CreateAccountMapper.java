package pl.nn.exchange.domain.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.CollectionUtils;
import pl.nn.exchange.domain.account.model.CreateAccountQuery;
import pl.nn.exchange.domain.account.model.CreateAccountQueryResult;
import pl.nn.exchange.domain.account.model.GetAccountResult;
import pl.nn.exchange.domain.account.model.GetAllAccountsResult;
import pl.nn.exchange.external.storage.model.Account;
import pl.nn.exchange.external.storage.model.Wallet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static pl.nn.exchange.infrastructure.config.BigDecimalConst.ROUNDING_MODE;
import static pl.nn.exchange.infrastructure.config.BigDecimalConst.SCALE;

@Mapper(componentModel = "spring")
abstract class CreateAccountMapper {

    @Mapping(target = "wallets", source = "startBalance")
    abstract Account map(CreateAccountQuery query);

    abstract CreateAccountQueryResult map(Account account);

    List<Wallet> createWallets(BigDecimal startBalance) {
        return List.of(createWallet(Wallet.Currency.PLN, startBalance), createWallet(Wallet.Currency.USD, BigDecimal.ZERO));
    }

    Wallet createWallet(Wallet.Currency currency, BigDecimal amount) {
        var resultAmount = amount.setScale(SCALE, ROUNDING_MODE);
        return Wallet.builder().currency(currency).amount(resultAmount).build();
    }

    abstract pl.nn.exchange.domain.common.model.Account mapAccount(Account account);


    abstract GetAccountResult mapGetAccountResult(Account account);


    GetAllAccountsResult map(List<Account> accounts) {
        List<pl.nn.exchange.domain.common.model.Account> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(accounts)) {
            accounts.forEach(it -> {
                result.add(mapAccount(it));
            });
        }
        return GetAllAccountsResult.builder().accounts(result).build();
    }


}
