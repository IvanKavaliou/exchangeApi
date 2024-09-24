package pl.nn.exchange.domain.exchange.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record GetExchangeRateResult(String currencyCode, BigDecimal bid, BigDecimal ask) {
}
