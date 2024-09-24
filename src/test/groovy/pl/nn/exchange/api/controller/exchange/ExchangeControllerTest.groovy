package pl.nn.exchange.api.controller.exchange

import pl.nn.exchange.domain.exchange.model.CurrencyCode
import pl.nn.exchange.domain.in.ExchangeUseCase
import spock.lang.Specification

class ExchangeControllerTest extends Specification implements ExchangeControllerFixture {

    ExchangeUseCase exchangeUseCase = Mock()
    ExchangeApiMapper mapper = Mock()

    ExchangeController controller

    def setup() {
        controller = new ExchangeController(exchangeUseCase, mapper)
    }

    def 'getExchangeRateTest'() {
        given:
        def currencyCode = CurrencyCode.USD
        def getExchangeRateResult = createGetExchangeRateResult()
        def response = createGetExchangeRateResponse()

        when:
        def result = controller.getExchangeRate(currencyCode)

        then:
        1 * exchangeUseCase.getExchangeRate(currencyCode) >> getExchangeRateResult
        1 * mapper.map(getExchangeRateResult) >> response
        0 * _
        noExceptionThrown()
        result == response
    }

    def 'exchangeTest'() {
        given:
        def request = createExchangeRequest()
        def query = createExchangeQuery()
        def queryResult = exchangeQueryResult()
        def response = createExchangeResponse()

        when:
        def result = controller.exchange(request)

        then:
        1 * mapper.map(request) >> query
        1 * exchangeUseCase.exchange(query) >> queryResult
        1 * mapper.map(queryResult) >> response
        0 * _
        noExceptionThrown()
        result == response
    }
}
