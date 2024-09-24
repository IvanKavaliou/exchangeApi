package pl.nn.exchange.api.controller.exchange;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
record ExchangeRequest(Integer accountId, Currency from, Currency to, BigDecimal amount) {

    enum Currency {
        PLN, USD
    }
}
