package pl.nn.exchange.fixture

import pl.nn.exchange.domain.common.model.Wallet
import pl.nn.exchange.domain.exchange.model.ExchangeQuery
import pl.nn.exchange.domain.exchange.model.ExchangeQueryResult
import pl.nn.exchange.domain.exchange.model.GetExchangeRateResult
import pl.nn.exchange.external.nbp.model.ExchangeRateResponse

trait ExchangeFixture implements AccountFixture {

    static final Integer ACCOUNT_ID = 1
    static final String CURRENCY_CODE = 'USD'
    static final BigDecimal BID = BigDecimal.valueOf(1L)
    static final BigDecimal ASK = BigDecimal.valueOf(1L)
    static final BigDecimal AMOUNT = BigDecimal.valueOf(1L)
    static final Wallet.Currency QUERY_FROM = Wallet.Currency.PLN
    static final Wallet.Currency QUERY_TO = Wallet.Currency.USD

    GetExchangeRateResult createGetExchangeRateResult() {
        GetExchangeRateResult.builder()
                .currencyCode(CURRENCY_CODE)
                .bid(BID)
                .ask(ASK)
                .build()
    }

    ExchangeQuery createExchangeQuery() {
        ExchangeQuery.builder()
                .accountId(ACCOUNT_ID)
                .amount(AMOUNT)
                .from(QUERY_FROM)
                .to(QUERY_TO)
                .build()
    }

    ExchangeQueryResult exchangeQueryResult() {
        ExchangeQueryResult.builder()
                .account(createAccountDto())
                .build()
    }

    ExchangeRateResponse createExchangeRateResponse(){
        ExchangeRateResponse.builder()
                .currency(CURRENCY_CODE)
                .rates([createRateDto()])
                .build()
    }

    ExchangeRateResponse.RateDto createRateDto(){
        ExchangeRateResponse.RateDto.builder()
                .ask(ASK)
                .bid(BID)
                .build()
    }
}