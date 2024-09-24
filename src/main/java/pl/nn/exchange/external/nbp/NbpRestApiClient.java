package pl.nn.exchange.external.nbp;

import pl.nn.exchange.external.nbp.model.CurrencyCode;
import pl.nn.exchange.external.nbp.model.ExchangeRateResponse;

public interface NbpRestApiClient {
    ExchangeRateResponse getExchangeRate(CurrencyCode currencyCode);
    ExchangeRateResponse.RateDto getUsdRate();
}
