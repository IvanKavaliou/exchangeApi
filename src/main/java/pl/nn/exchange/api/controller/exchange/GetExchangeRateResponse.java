package pl.nn.exchange.api.controller.exchange;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
record GetExchangeRateResponse(String currencyCode, BigDecimal bid, BigDecimal ask) {
}
