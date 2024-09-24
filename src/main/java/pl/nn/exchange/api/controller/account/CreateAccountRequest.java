package pl.nn.exchange.api.controller.account;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
record CreateAccountRequest(String firstName, String lastName, BigDecimal startBalance) {
}
