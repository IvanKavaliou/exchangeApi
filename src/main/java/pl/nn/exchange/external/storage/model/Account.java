package pl.nn.exchange.external.storage.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Account {
    Integer id;
    String firstName;
    String lastName;
    List<Wallet> wallets;
}
