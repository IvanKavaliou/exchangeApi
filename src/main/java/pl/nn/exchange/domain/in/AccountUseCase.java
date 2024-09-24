package pl.nn.exchange.domain.in;

import pl.nn.exchange.domain.account.model.CreateAccountQuery;
import pl.nn.exchange.domain.account.model.CreateAccountQueryResult;
import pl.nn.exchange.domain.account.model.GetAccountResult;
import pl.nn.exchange.domain.account.model.GetAllAccountsResult;

public interface AccountUseCase {
    CreateAccountQueryResult createAccount(CreateAccountQuery query);
    GetAccountResult getAccount(Integer id);
    GetAllAccountsResult getAllAccounts();
}
