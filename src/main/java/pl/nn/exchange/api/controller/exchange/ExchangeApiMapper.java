package pl.nn.exchange.api.controller.exchange;

import org.mapstruct.Mapper;
import pl.nn.exchange.domain.exchange.model.ExchangeQuery;
import pl.nn.exchange.domain.exchange.model.ExchangeQueryResult;
import pl.nn.exchange.domain.exchange.model.GetExchangeRateResult;

@Mapper(componentModel = "spring")
abstract class ExchangeApiMapper {

    abstract GetExchangeRateResponse map(GetExchangeRateResult result);

    abstract ExchangeQuery map(ExchangeRequest request);

    abstract ExchangeResponse map(ExchangeQueryResult queryResult);
}
