package pl.nn.exchange.api.controller.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SwaggerConst {
    public static final String GET_EXCHANGE_RATE_SUMMARY = "Pobranie aktualnego kursu waluty";
    public static final String GET_EXCHANGE_RATE_DESCRIPTION = "Pobranie aktualnego kursu waluty ze strony NBP";
    public static final String CURRENCY_CODE_NAME = "currencyCode";
    public static final String CURRENCY_CODE_DESCRIPTION = "Kod waluty (standard ISO 4217)";
    public static final String EXCHANGE_SUMMARY = "Wymiana wauty";
    public static final String EXCHANGE_DESCRIPTION = "Do wymany nalieży podać id konta, walutę spredaży, walutę kupna, oraz kwotę sprzedaży.";
    public static final String CREATE_ACCOUNT_SUMMARY = "Założenie konta użytkownika";
    public static final String CREATE_ACCOUNT_DESCRIPTION = "Nałeży podać imie i zawisko użytkownika oraz podanie początkowego salda konta w PLN.";
    public static final String GET_ACCOUNT_SUMMARY = "Pobranie konta użytkownika";
    public static final String GET_ACCOUNT_DESCRIPTION = "Pobrania danych o koncie i jego aktualnego stanu";
    public static final String GET_ALL_ACCOUNTS_SUMMARY = "Pobranie wszyskich kont w systemie";
    public static final String GET_ALL_ACCOUNTS_DESCRIPTION = "Pobrania danych o wszystkich kontach systemu";
}
