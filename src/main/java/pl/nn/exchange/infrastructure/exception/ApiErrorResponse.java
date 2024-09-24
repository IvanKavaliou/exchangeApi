package pl.nn.exchange.infrastructure.exception;

import lombok.Builder;

@Builder
record ApiErrorResponse(String message, String description) {
}
