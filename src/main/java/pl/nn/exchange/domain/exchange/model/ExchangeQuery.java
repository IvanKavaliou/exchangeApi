package pl.nn.exchange.domain.exchange.model;

import lombok.Builder;
import pl.nn.exchange.domain.common.model.Wallet;

import java.math.BigDecimal;

@Builder
public record ExchangeQuery(Integer accountId, Wallet.Currency from, Wallet.Currency to, BigDecimal amount) {
}
