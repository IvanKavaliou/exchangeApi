package pl.nn.exchange.domain.exchange;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.nn.exchange.domain.exchange.model.CurrencyCode;
import pl.nn.exchange.domain.exchange.model.ExchangeQueryResult;
import pl.nn.exchange.domain.exchange.model.GetExchangeRateResult;
import pl.nn.exchange.external.nbp.model.ExchangeRateResponse;
import pl.nn.exchange.external.storage.model.Account;
import pl.nn.exchange.external.storage.model.Wallet;
import pl.nn.exchange.infrastructure.exception.TechnicalException;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring")
abstract class ExchangeMapper {

    abstract pl.nn.exchange.external.nbp.model.CurrencyCode map(CurrencyCode currencyCode);

    @Mapping(target = "currencyCode", source = "code")
    @Mapping(target = "bid", expression = "java(getBid(response))")
    @Mapping(target = "ask", expression = "java(getAsk(response))")
    abstract GetExchangeRateResult map(ExchangeRateResponse response);

    BigDecimal getBid(ExchangeRateResponse response) {
        return Optional.of(response.rates())
                .orElseThrow(() -> new TechnicalException("Rates table is null"))
                .stream()
                .findFirst()
                .orElseThrow(() -> new TechnicalException("Rates table is null"))
                .bid();
    }

    BigDecimal getAsk(ExchangeRateResponse response) {
        return Optional.of(response.rates())
                .orElseThrow(() -> new TechnicalException("Rates table is null"))
                .stream()
                .findFirst()
                .orElseThrow(() -> new TechnicalException("Rates table is null"))
                .ask();
    }

   abstract Wallet.Currency map(pl.nn.exchange.domain.common.model.Wallet.Currency currency);

    abstract ExchangeQueryResult map (Account account);
}
