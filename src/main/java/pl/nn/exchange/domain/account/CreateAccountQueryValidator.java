package pl.nn.exchange.domain.account;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.nn.exchange.domain.account.model.CreateAccountQuery;
import pl.nn.exchange.infrastructure.exception.BusinessValidationException;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

@Component
class CreateAccountQueryValidator {

    void validate(CreateAccountQuery query) {
        if (isNull(query)) {
            throw new BusinessValidationException("CreateAccountQuery is null.", "CreateAccountQuery can't be null.");
        }
        if (StringUtils.isBlank(query.firstName())){
            throw new BusinessValidationException("FirstName is blank.", "FirstName can't be blank.");
        }
        if (StringUtils.isBlank(query.lastName())){
            throw new BusinessValidationException("LastName is blank.", "LastName can't be blank.");
        }
        if (isNull(query.startBalance())) {
            throw new BusinessValidationException("StartBalance is null.", "StartBalance can't be null.");
        }
        if (BigDecimal.ZERO.compareTo(query.startBalance()) >=0 ){
            throw new BusinessValidationException("Incorrect StartBalance value.", "StartBalance can't be less than or equal zero.");
        }
    }
}
