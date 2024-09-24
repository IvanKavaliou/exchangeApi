package pl.nn.exchange.infrastructure.exception;

import pl.nn.exchange.external.storage.model.Account;

import static java.lang.String.format;

public class WalletNotFoundException extends BusinessValidationException {
    public WalletNotFoundException(Integer accountId, String currencyCode) {
        super("Wallet not found", format("Wallet for account id: %s not found. CurrencyCode: %s", accountId, currencyCode));
    }
}
