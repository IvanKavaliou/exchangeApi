package pl.nn.exchange.domain.account

import pl.nn.exchange.external.storage.AccountRepository
import pl.nn.exchange.fixture.AccountFixture
import pl.nn.exchange.infrastructure.exception.AccountNotFoundException
import spock.lang.Specification

class CreateAccountHandlerTest extends Specification implements AccountFixture {

    AccountRepository accountRepository = Mock()
    CreateAccountQueryValidator validator = Mock()
    CreateAccountMapper mapper = Mock()

    CreateAccountHandler handler

    def setup() {
        handler = new CreateAccountHandler(accountRepository, validator, mapper)
    }

    def 'createAccountTest'() {
        given:
        def query = createCreateAccountQuery()
        def account = createStorageAccount()
        def queryResult = createAccountQueryResult()

        when:
        def result = handler.createAccount(query)

        then:
        1 * validator.validate(query) >> {}
        1 * mapper.map(query) >> account
        1 * accountRepository.save(account) >> account
        1 * mapper.map(account) >> queryResult
        0 * _
        noExceptionThrown()
        result == queryResult
    }

    def 'getAccountTest'() {
        given:
        def account = createStorageAccount()
        def getAccountResult = createGetAccountResult()

        when:
        def result = handler.getAccount(ID)

        then:
        1 * accountRepository.get(ID) >> Optional.of(account)
        1 * mapper.mapGetAccountResult(account) >> getAccountResult
        0 * _
        noExceptionThrown()
        result == getAccountResult
    }

    def 'getAccountTest and throw AccountNotFoundException'() {
        when:
        handler.getAccount(ID)

        then:
        1 * accountRepository.get(ID) >> Optional.empty()
        0 * _
        def e = thrown(AccountNotFoundException.class)
        e.message == 'Account not found'
        e.description == 'Account with id: 1 not found.'
    }

    def 'getAllAccountsTest'() {
        given:
        def accounts = [createStorageAccount()]
        def getAllAccountsResult = createGetAllAccountsResult()

        when:
        def result = handler.getAllAccounts()

        then:
        1 * accountRepository.findAll() >> accounts
        1 * mapper.map(accounts) >> getAllAccountsResult
        0 * _
        noExceptionThrown()
        result == getAllAccountsResult
    }
}
