package pl.nn.exchange.domain.account.model;

import lombok.Builder;
import pl.nn.exchange.domain.common.model.Account;

import java.util.List;

@Builder
public record GetAllAccountsResult(List<Account> accounts) {
}
