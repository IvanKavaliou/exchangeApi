package pl.nn.exchange.api.controller.exchange

import pl.nn.exchange.fixture.ExchangeFixture

trait ExchangeControllerFixture implements ExchangeFixture{

    static final ExchangeRequest.Currency FROM = ExchangeRequest.Currency.PLN
    static final ExchangeRequest.Currency TO = ExchangeRequest.Currency.USD

    GetExchangeRateResponse createGetExchangeRateResponse() {
        GetExchangeRateResponse.builder()
                .currencyCode(CURRENCY_CODE)
                .bid(BID)
                .ask(ASK)
                .build()
    }

    ExchangeRequest createExchangeRequest(){
        ExchangeRequest.builder()
                .accountId(ACCOUNT_ID)
                .from(FROM)
                .to(TO)
                .amount(AMOUNT)
                .build()
    }

    ExchangeResponse createExchangeResponse(){
        ExchangeResponse.builder()
                .account(createAccountDto())
                .build()
    }
}