package pl.nn.exchange.api.controller.account

import org.mapstruct.factory.Mappers
import spock.lang.Specification

class AccountControllerMapperTest extends Specification implements AccountControllerFixture {

    AccountControllerMapper mapper

    def setup() {
        mapper = Mappers.getMapper(AccountControllerMapper.class)
    }

    def 'mapCreateAccountQueryTest'(){
        given:
        def request = createAccountRequest()

        when:
        def result = mapper.map(request)

        then:
        result.firstName() == request.firstName()
        result.lastName() == request.lastName()
        result.startBalance() == request.startBalance()
    }

    def 'mapCreateAccountResponseTest'() {
        given:
        def queryResult = createAccountQueryResult()

        when:
        def result = mapper.map(queryResult)

        then:
        result.account().firstName() == queryResult.account().firstName
        result.account().lastName() == queryResult.account().lastName
        result.account().id() == queryResult.account().id
        result.account().wallets().get(0).currency().name() == queryResult.account().wallets[0].currency.name()
        result.account().wallets().get(0).amount() == queryResult.account().wallets[0].amount
        result.account().wallets().get(1).currency().name() == queryResult.account().wallets[1].currency.name()
        result.account().wallets().get(1).amount() == queryResult.account().wallets[1].amount
    }

    def 'mapGetAccountResponseTest'() {
        given:
        def getAccountResult = createGetAccountResult()

        when:
        def result = mapper.map(getAccountResult)

        then:
        result.account().firstName() == getAccountResult.account().firstName
        result.account().lastName() == getAccountResult.account().lastName
        result.account().id() == getAccountResult.account().id
        result.account().wallets().get(0).currency().name() == getAccountResult.account().wallets[0].currency.name()
        result.account().wallets().get(0).amount() == getAccountResult.account().wallets[0].amount
        result.account().wallets().get(1).currency().name() == getAccountResult.account().wallets[1].currency.name()
        result.account().wallets().get(1).amount() == getAccountResult.account().wallets[1].amount
    }

    def 'mapGetAllAccountsResponseTest'() {
        given:
        def getAllAccountsResult = createGetAllAccountsResult()

        when:
        def result = mapper.map(getAllAccountsResult)

        then:
        result.accounts().get(0).id() == getAllAccountsResult.accounts().get(0).id
        result.accounts().get(0).firstName() == getAllAccountsResult.accounts().get(0).firstName
        result.accounts().get(0).lastName() == getAllAccountsResult.accounts().get(0).lastName
        result.accounts().get(0).wallets().get(0).amount() == getAllAccountsResult.accounts().get(0).wallets.get(0).amount
        result.accounts().get(0).wallets().get(0).currency().name() == getAllAccountsResult.accounts().get(0).wallets.get(0).currency.name()
    }

    CreateAccountRequest createAccountRequest() {
        CreateAccountRequest.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .startBalance(START_BALANCE)
                .build()
    }
}
