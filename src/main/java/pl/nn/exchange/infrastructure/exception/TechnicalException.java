package pl.nn.exchange.infrastructure.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TechnicalException extends RuntimeException{
    private final String message;
}
