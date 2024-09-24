package pl.nn.exchange.api.controller.account;

import org.mapstruct.Mapper;
import pl.nn.exchange.domain.account.model.CreateAccountQuery;
import pl.nn.exchange.domain.account.model.CreateAccountQueryResult;
import pl.nn.exchange.domain.account.model.GetAccountResult;
import pl.nn.exchange.domain.account.model.GetAllAccountsResult;

@Mapper(componentModel = "spring")
abstract class AccountControllerMapper {

    abstract CreateAccountQuery map(CreateAccountRequest request);

    abstract CreateAccountResponse map(CreateAccountQueryResult result);

    abstract GetAccountResponse map(GetAccountResult result);

    abstract GetAllAccountsResponse map(GetAllAccountsResult result);
}
