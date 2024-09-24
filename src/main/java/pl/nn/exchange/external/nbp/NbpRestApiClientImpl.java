package pl.nn.exchange.external.nbp;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import pl.nn.exchange.external.nbp.model.CurrencyCode;
import pl.nn.exchange.external.nbp.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
class NbpRestApiClientImpl implements NbpRestApiClient {

    private final WebClient webClient;

    @Value("${nbp.urls.exchangeRates}")
    @Setter
    private String uri;

    @Override
    public ExchangeRateResponse getExchangeRate(CurrencyCode currencyCode) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(uri).build(Map.of("currencyCode",currencyCode.name())))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, this::handleClientError)
                .onStatus(HttpStatusCode::is5xxServerError, this::handleClientError)
                .bodyToMono(ExchangeRateResponse.class)
                .block();
    }

    @Override
    public ExchangeRateResponse.RateDto getUsdRate() {
        return getExchangeRate(CurrencyCode.USD)
                .rates().stream().findFirst().orElseThrow();
    }

    private Mono<? extends Throwable> handleClientError(ClientResponse clientResponse) {
        return Mono.error(new NbpApiException(format("Nbp api return some error, httpStatus: %s ", clientResponse.statusCode())));
    }
}
