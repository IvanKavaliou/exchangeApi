package pl.nn.exchange.domain.exchange

import pl.nn.exchange.domain.exchange.model.CurrencyCode
import pl.nn.exchange.external.nbp.NbpRestApiClient
import pl.nn.exchange.external.storage.AccountRepository
import pl.nn.exchange.fixture.ExchangeFixture
import spock.lang.Specification

class ExchangeHandlerTest extends Specification implements ExchangeFixture {

    NbpRestApiClient nbpRestApiClient = Mock()
    AccountRepository accountRepository = Mock()
    ExchangeMapper mapper = Mock()
    ExchangeQueryValidator validator = Mock()

    ExchangeHandler handler

    def setup() {
        handler = new ExchangeHandler(nbpRestApiClient, accountRepository, mapper, validator)
    }

    def 'getExchangeRateTest'() {
        given:
        def currencyCode = CurrencyCode.USD
        def nbpCurrency = pl.nn.exchange.external.nbp.model.CurrencyCode.USD
        def nbpResponse = createExchangeRateResponse()
        def mapperResult = createGetExchangeRateResult()

        when:
        def result = handler.getExchangeRate(CurrencyCode.USD)

        then:
        1 * mapper.map(currencyCode) >> nbpCurrency
        1 * nbpRestApiClient.getExchangeRate(nbpCurrency) >> nbpResponse
        1 * mapper.map(nbpResponse) >> mapperResult
        0 * _
        noExceptionThrown()
        result == mapperResult
    }
}
