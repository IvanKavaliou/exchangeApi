package pl.nn.exchange.api.controller.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nn.exchange.domain.in.AccountUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("account")
class AccountController {

    private final AccountUseCase accountUseCase;
    private final AccountControllerMapper mapper;

    @CreateAccountSwagger
    @PostMapping("/create")
    CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        var queryResult = accountUseCase.createAccount(mapper.map(request));
        return mapper.map(queryResult);
    }

    @GetAccountSwagger
    @GetMapping("/{id}")
    GetAccountResponse getAccount(@PathVariable Integer id) {
        var getAccountResult = accountUseCase.getAccount(id);
        return mapper.map(getAccountResult);
    }

    @GetAllAccountsSwagger
    @GetMapping("/")
    GetAllAccountsResponse getAllAccounts() {
        return mapper.map(accountUseCase.getAllAccounts());
    }
}
