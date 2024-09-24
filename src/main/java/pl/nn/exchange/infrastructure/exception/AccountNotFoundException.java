package pl.nn.exchange.infrastructure.exception;

import static java.lang.String.format;

public class AccountNotFoundException extends BusinessValidationException {

    public AccountNotFoundException(Integer id) {
        super("Account not found", format("Account with id: %s not found.", id));
    }
}
