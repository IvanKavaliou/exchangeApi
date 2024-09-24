package pl.nn.exchange.api.controller.account

import pl.nn.exchange.fixture.AccountFixture

trait AccountControllerFixture implements AccountFixture {

    CreateAccountResponse createAccountResponse() {
        CreateAccountResponse.builder()
                .account(createAccountDto())
                .build()
    }

    CreateAccountRequest createAccountRequest() {
        CreateAccountRequest.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .startBalance(START_BALANCE)
                .build()
    }


    GetAllAccountsResponse createGetAllAccountsResponse() {
        GetAllAccountsResponse.builder()
                .accounts([createAccountDto()])
                .build()
    }

    GetAccountResponse createGetAccountResponse() {
        GetAccountResponse.builder()
                .account(createAccountDto())
                .build()
    }
}