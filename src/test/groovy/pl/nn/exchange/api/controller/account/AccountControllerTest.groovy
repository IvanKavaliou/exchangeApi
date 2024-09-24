package pl.nn.exchange.api.controller.account

import pl.nn.exchange.domain.in.AccountUseCase
import spock.lang.Specification

class AccountControllerTest extends Specification implements AccountControllerFixture {

    AccountUseCase accountUseCase = Mock()
    AccountControllerMapper mapper = Mock()

    AccountController controller


    def setup() {
        controller = new AccountController(accountUseCase, mapper)
    }

    def 'createAccountTest'() {
        given:
        def request = createAccountRequest()
        def createAccountQuery = createCreateAccountQuery()
        def queryResult = createAccountQueryResult()
        def createAccountResponse = createAccountResponse()

        when:
        def result = controller.createAccount(request)

        then:
        1 * mapper.map(request) >> createAccountQuery
        1 * accountUseCase.createAccount(createAccountQuery) >> queryResult
        1 * mapper.map(queryResult) >> createAccountResponse
        0 * _
        noExceptionThrown()
        result == createAccountResponse
    }

    def 'getAccountTest'() {
        given:
        def getAccountResult = createGetAccountResult()
        def getAccountResponse = createGetAccountResponse()

        when:
        def result = controller.getAccount(ID)

        then:
        1 * accountUseCase.getAccount(ID) >> getAccountResult
        1 * mapper.map(getAccountResult) >> getAccountResponse
        0 * _
        noExceptionThrown()
        result == getAccountResponse
    }

    def 'getAllAccountsTest'() {
        given:
        def getAllAccountsResult = createGetAllAccountsResult()
        def getAllAccountsResponse = createGetAllAccountsResponse()

        when:
        def result = controller.getAllAccounts()

        then:
        1 * accountUseCase.getAllAccounts() >> getAllAccountsResult
        1 * mapper.map(getAllAccountsResult) >> getAllAccountsResponse
        0 * _
        noExceptionThrown()
        result == getAllAccountsResponse
    }
}
