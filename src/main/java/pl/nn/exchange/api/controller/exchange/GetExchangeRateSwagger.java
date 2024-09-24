package pl.nn.exchange.api.controller.exchange;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static pl.nn.exchange.api.controller.common.SwaggerConst.CURRENCY_CODE_DESCRIPTION;
import static pl.nn.exchange.api.controller.common.SwaggerConst.CURRENCY_CODE_NAME;
import static pl.nn.exchange.api.controller.common.SwaggerConst.GET_EXCHANGE_RATE_DESCRIPTION;
import static pl.nn.exchange.api.controller.common.SwaggerConst.GET_EXCHANGE_RATE_SUMMARY;

@Operation(summary = GET_EXCHANGE_RATE_SUMMARY, description = GET_EXCHANGE_RATE_DESCRIPTION)
@Parameters({
        @Parameter(name = CURRENCY_CODE_NAME, description = CURRENCY_CODE_DESCRIPTION)
})
@Target({METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE, PARAMETER})
@Retention(RUNTIME)
@Documented
@interface GetExchangeRateSwagger {
}
