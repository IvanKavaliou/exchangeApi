package pl.nn.exchange.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Account {
    Integer id;
    String firstName;
    String lastName;
    List<Wallet> wallets;
}
