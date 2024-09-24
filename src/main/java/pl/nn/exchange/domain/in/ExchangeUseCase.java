package pl.nn.exchange.domain.in;

import pl.nn.exchange.domain.exchange.model.CurrencyCode;
import pl.nn.exchange.domain.exchange.model.ExchangeQuery;
import pl.nn.exchange.domain.exchange.model.ExchangeQueryResult;
import pl.nn.exchange.domain.exchange.model.GetExchangeRateResult;

public interface ExchangeUseCase {

    GetExchangeRateResult getExchangeRate(CurrencyCode currencyCode);

    ExchangeQueryResult exchange(ExchangeQuery query);
}
