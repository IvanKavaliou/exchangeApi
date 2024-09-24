package pl.nn.exchange.domain.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nn.exchange.domain.exchange.model.ExchangeQuery;
import pl.nn.exchange.infrastructure.exception.BusinessValidationException;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
class ExchangeQueryValidator {

    public void validate(ExchangeQuery query) {
        if (isNull(query)) {
            throw new BusinessValidationException("ExchangeQuery can't be null.");
        }

        if (isNull(query.accountId())){
            throw new BusinessValidationException("AccountId can't be null.");
        }

        if (isNull(query.from())){
            throw new BusinessValidationException("From can't be null.");
        }

        if (isNull(query.to())){
            throw new BusinessValidationException("To can't be null.");
        }

        if (isNull(query.amount())){
            throw new BusinessValidationException("Amount can't be null.");
        }

        if (query.from().equals(query.to())) {
            throw new BusinessValidationException("Currency from and to can't be equals.");
        }

        if (BigDecimal.ZERO.compareTo(query.amount()) >= 0) {
            throw new BusinessValidationException("Amount can't be negative or equal zero.");
        }
    }
}
