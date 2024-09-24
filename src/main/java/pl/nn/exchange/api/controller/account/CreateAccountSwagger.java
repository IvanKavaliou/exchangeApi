package pl.nn.exchange.api.controller.account;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static pl.nn.exchange.api.controller.common.SwaggerConst.CREATE_ACCOUNT_DESCRIPTION;
import static pl.nn.exchange.api.controller.common.SwaggerConst.CREATE_ACCOUNT_SUMMARY;

@Operation(summary = CREATE_ACCOUNT_SUMMARY, description = CREATE_ACCOUNT_DESCRIPTION)
@Target({METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE, PARAMETER})
@Retention(RUNTIME)
@Documented
@interface CreateAccountSwagger {
}
