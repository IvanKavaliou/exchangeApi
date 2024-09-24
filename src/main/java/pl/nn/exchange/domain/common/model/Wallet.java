package pl.nn.exchange.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Wallet {
    private Currency currency;
    private BigDecimal amount;

    public enum Currency {
        PLN,
        USD
    }
}
