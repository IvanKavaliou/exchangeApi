package pl.nn.exchange.domain.account.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateAccountQuery(String firstName, String lastName, BigDecimal startBalance) {
}
