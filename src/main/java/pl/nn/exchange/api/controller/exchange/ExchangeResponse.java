package pl.nn.exchange.api.controller.exchange;

import lombok.Builder;
import pl.nn.exchange.api.controller.common.dto.AccountDto;

@Builder
record ExchangeResponse(AccountDto account) {
}
