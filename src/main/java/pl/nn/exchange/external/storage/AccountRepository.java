package pl.nn.exchange.external.storage;

import pl.nn.exchange.external.storage.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> get(Integer id);
    List<Account> findAll();
}
