package pl.nn.exchange.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nn.exchange.domain.account.model.CreateAccountQuery;
import pl.nn.exchange.domain.account.model.CreateAccountQueryResult;
import pl.nn.exchange.domain.account.model.GetAccountResult;
import pl.nn.exchange.domain.account.model.GetAllAccountsResult;
import pl.nn.exchange.domain.in.AccountUseCase;
import pl.nn.exchange.external.storage.AccountRepository;
import pl.nn.exchange.infrastructure.exception.AccountNotFoundException;

@Component
@RequiredArgsConstructor
class CreateAccountHandler implements AccountUseCase {

    private final AccountRepository accountRepository;
    private final CreateAccountQueryValidator validator;
    private final CreateAccountMapper mapper;

    public CreateAccountQueryResult createAccount(CreateAccountQuery query) {
        validator.validate(query);
        var account = accountRepository.save(mapper.map(query));
        return mapper.map(account);
    }

    @Override
    public GetAccountResult getAccount(Integer id) {
        var account = accountRepository
                .get(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        return mapper.mapGetAccountResult(account);
    }

    @Override
    public GetAllAccountsResult getAllAccounts() {
        return mapper.map(accountRepository.findAll());
    }
}
