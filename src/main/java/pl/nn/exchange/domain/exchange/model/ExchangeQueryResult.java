package pl.nn.exchange.domain.exchange.model;

import lombok.Builder;
import pl.nn.exchange.api.controller.common.dto.AccountDto;

@Builder
public record ExchangeQueryResult(AccountDto account) {
}
