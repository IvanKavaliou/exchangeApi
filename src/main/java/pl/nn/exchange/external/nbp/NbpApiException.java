package pl.nn.exchange.external.nbp;

import pl.nn.exchange.infrastructure.exception.TechnicalException;

class NbpApiException extends TechnicalException {
    public NbpApiException(String message) {
        super(message);
    }
}
