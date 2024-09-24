package pl.nn.exchange.domain.account

import pl.nn.exchange.domain.account.model.CreateAccountQuery
import pl.nn.exchange.fixture.AccountFixture
import pl.nn.exchange.infrastructure.exception.BusinessValidationException
import spock.lang.Specification

class CreateAccountQueryValidatorTest extends Specification implements AccountFixture {

    CreateAccountQueryValidator validator

    def setup() {
        validator = new CreateAccountQueryValidator()
    }

    def 'validateTest'() {
        when:
        validator.validate(createCreateAccountQuery())

        then:
        noExceptionThrown()
    }

    def 'validate with null query'() {
        when:
        validator.validate(null)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'CreateAccountQuery is null.'
        e.description == 'CreateAccountQuery can\'t be null.'
    }

    def 'validate with blank firstName'() {
        given:
        def query = CreateAccountQuery.builder()
                .firstName("")
                .lastName(LAST_NAME)
                .startBalance(START_BALANCE)
                .build()

        when:
        validator.validate(query)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'FirstName is blank.'
        e.description == 'FirstName can\'t be blank.'
    }

    def 'validate with blank lastName'() {
        given:
        def query = CreateAccountQuery.builder()
                .firstName(FIRST_NAME)
                .lastName("")
                .startBalance(START_BALANCE)
                .build()

        when:
        validator.validate(query)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'LastName is blank.'
        e.description == 'LastName can\'t be blank.'
    }

    def 'validate with zero balance'() {
        given:
        def query = CreateAccountQuery.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .startBalance(BigDecimal.ZERO)
                .build()

        when:
        validator.validate(query)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'Incorrect StartBalance value.'
        e.description == 'StartBalance can\'t be less than or equal zero.'
    }

    def 'validate with negative balance'() {
        given:
        def query = CreateAccountQuery.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .startBalance(BigDecimal.valueOf(-1L))
                .build()

        when:
        validator.validate(query)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'Incorrect StartBalance value.'
        e.description == 'StartBalance can\'t be less than or equal zero.'
    }

    def 'validate with null balance'() {
        given:
        def query = CreateAccountQuery.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build()

        when:
        validator.validate(query)

        then:
        def e = thrown(BusinessValidationException.class)
        e.message == 'StartBalance is null.'
        e.description == 'StartBalance can\'t be null.'
    }
}
