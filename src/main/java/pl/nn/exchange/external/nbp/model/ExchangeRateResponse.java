package pl.nn.exchange.external.nbp.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ExchangeRateResponse(String table, String currency, CurrencyCode code, List<RateDto> rates) {

    @Builder
    public record RateDto(String no, String effectiveDate, BigDecimal bid, BigDecimal ask){}
}
