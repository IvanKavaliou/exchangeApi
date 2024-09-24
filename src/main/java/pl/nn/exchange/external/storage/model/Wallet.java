package pl.nn.exchange.external.storage.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Wallet {

    Currency currency;
    BigDecimal amount;

    public enum Currency {
        USD,
        PLN
    }

}
