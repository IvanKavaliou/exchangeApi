package pl.nn.exchange.api.controller.exchange;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nn.exchange.domain.exchange.model.CurrencyCode;
import pl.nn.exchange.domain.in.ExchangeUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("exchange")
class ExchangeController {

    private final ExchangeUseCase exchangeUseCase;
    private final ExchangeApiMapper mapper;


    @GetExchangeRateSwagger
    @GetMapping("/rate/{currencyCode}")
    GetExchangeRateResponse getExchangeRate(@PathVariable CurrencyCode currencyCode) {
        var result = exchangeUseCase.getExchangeRate(currencyCode);
        return mapper.map(result);
    }

    @ExchangeSwagger
    @PostMapping
    ExchangeResponse exchange(@RequestBody ExchangeRequest request) {
        var queryResult = exchangeUseCase.exchange(mapper.map(request));
        return mapper.map(queryResult);
    }
}
