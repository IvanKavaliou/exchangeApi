package pl.nn.exchange.external.storage;

import org.springframework.stereotype.Component;
import pl.nn.exchange.external.storage.model.Account;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.isNull;

@Component
class AccountStorage implements AccountRepository {

    private static final Map<Integer, Account> ACCOUNTS = new ConcurrentHashMap<>();
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public Account save(Account account) {
        if (isNull(account.getId())){
            account.setId(COUNTER.incrementAndGet());
            ACCOUNTS.put(account.getId(), account);
            return account;
        }

        return ACCOUNTS.computeIfPresent(account.getId(), (id, old) -> account);
    }

    @Override
    public Optional<Account> get(Integer id) {
        return Optional.ofNullable(ACCOUNTS.get(id));
    }

    @Override
    public List<Account> findAll() {
        return ACCOUNTS.values().stream().toList();
    }
}
