package pl.nn.exchange.fixture

import pl.nn.exchange.api.controller.account.CreateAccountRequest
import pl.nn.exchange.api.controller.account.CreateAccountResponse
import pl.nn.exchange.api.controller.account.GetAccountResponse
import pl.nn.exchange.api.controller.account.GetAllAccountsResponse
import pl.nn.exchange.api.controller.common.dto.AccountDto
import pl.nn.exchange.api.controller.common.dto.CurrencyDto
import pl.nn.exchange.domain.account.model.CreateAccountQuery
import pl.nn.exchange.domain.account.model.CreateAccountQueryResult
import pl.nn.exchange.domain.account.model.GetAccountResult
import pl.nn.exchange.domain.account.model.GetAllAccountsResult
import pl.nn.exchange.domain.common.model.Account
import pl.nn.exchange.domain.common.model.Wallet

trait AccountFixture {

    static final String FIRST_NAME = 'FirstName'
    static final String LAST_NAME = 'LastName'
    static final BigDecimal START_BALANCE = BigDecimal.valueOf(100L)
    static final Integer ID = 1

    CreateAccountQuery createCreateAccountQuery() {
        CreateAccountQuery.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .startBalance(START_BALANCE)
                .build()
    }

    CreateAccountQueryResult createAccountQueryResult() {
        CreateAccountQueryResult.builder()
                .account(createAccount())
                .build()
    }

    Account createAccount() {
        Account.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .id(ID)
                .wallets(createWallets())
                .build()
    }

    List<Wallet> createWallets() {
        [createWallet(START_BALANCE, Wallet.Currency.PLN), createWallet(BigDecimal.ZERO, Wallet.Currency.USD)]
    }

    Wallet createWallet(BigDecimal amount, Wallet.Currency currency) {
        Wallet.builder()
                .amount(amount)
                .currency(currency)
                .build()
    }

    AccountDto createAccountDto() {
        AccountDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .wallets(createWalletsDto())
                .build()
    }

    List<AccountDto.Wallet> createWalletsDto() {
        [createWalletDto(START_BALANCE, CurrencyDto.PLN), createWalletDto(BigDecimal.ZERO, CurrencyDto.USD)]
    }

    AccountDto.Wallet createWalletDto(BigDecimal amount, CurrencyDto currency) {
        AccountDto.Wallet.builder()
                .amount(amount)
                .currency(currency)
                .build()
    }

    GetAccountResult createGetAccountResult() {
        GetAccountResult.builder()
                .account(createAccount())
                .build()
    }

    GetAllAccountsResult createGetAllAccountsResult() {
        GetAllAccountsResult.builder()
                .accounts([createAccount()])
                .build()
    }

    pl.nn.exchange.external.storage.model.Account createStorageAccount(){
        pl.nn.exchange.external.storage.model.Account.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .wallets(createStorageWallets())
                .build()
    }

    List<pl.nn.exchange.external.storage.model.Wallet> createStorageWallets(){
        [createStorageWallet(START_BALANCE, pl.nn.exchange.external.storage.model.Wallet.Currency.PLN),
         createStorageWallet(BigDecimal.ZERO, pl.nn.exchange.external.storage.model.Wallet.Currency.USD)
        ]
    }

    pl.nn.exchange.external.storage.model.Wallet createStorageWallet(BigDecimal amount,
                                                                     pl.nn.exchange.external.storage.model.Wallet.Currency currency ){
        pl.nn.exchange.external.storage.model.Wallet.builder()
                .amount(amount)
                .currency(currency)
                .build()
    }
}