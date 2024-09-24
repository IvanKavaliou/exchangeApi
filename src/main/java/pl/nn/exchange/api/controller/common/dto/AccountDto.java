package pl.nn.exchange.api.controller.common.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public
record AccountDto(Integer id, String firstName, String lastName, List<Wallet> wallets) {

    @Builder
    public
    record Wallet(CurrencyDto currency, BigDecimal amount){}
}
