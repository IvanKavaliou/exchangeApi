package pl.nn.exchange.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessValidationException extends RuntimeException {
    private final String message;
    private final String description;

    public BusinessValidationException(String description) {
        this.message = "Validation exception";
        this.description = description;
    }
}
