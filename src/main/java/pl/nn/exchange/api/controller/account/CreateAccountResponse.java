package pl.nn.exchange.api.controller.account;

import lombok.Builder;
import pl.nn.exchange.api.controller.common.dto.AccountDto;

@Builder
record CreateAccountResponse(AccountDto account) {
}
