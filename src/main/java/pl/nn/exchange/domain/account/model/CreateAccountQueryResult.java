package pl.nn.exchange.domain.account.model;

import lombok.Builder;
import pl.nn.exchange.domain.common.model.Account;

@Builder
public record CreateAccountQueryResult(Account account) {
}
