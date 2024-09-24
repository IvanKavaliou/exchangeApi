package pl.nn.exchange.api.controller.account;

import lombok.Builder;
import pl.nn.exchange.api.controller.common.dto.AccountDto;

import java.util.List;

@Builder
record GetAllAccountsResponse(List<AccountDto> accounts) {
}
