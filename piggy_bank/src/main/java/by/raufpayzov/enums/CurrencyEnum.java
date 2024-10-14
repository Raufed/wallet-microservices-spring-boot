package by.raufpayzov.enums;

import java.util.Currency;

public enum CurrencyEnum {
    USD("USD"),
    EUR("EUR"),
    GBP("GBP");

    private String currencyCode;

    CurrencyEnum(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getSymbol() {
        Currency currency = Currency.getInstance(currencyCode);
        return currency.getSymbol();
    }

    public int getDefaultFractionDigits() {
        Currency currency = Currency.getInstance(currencyCode);
        return currency.getDefaultFractionDigits();
    }

    public static void main(String[] args) {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            System.out.println("Currency: " + currency.getCurrencyCode());
            System.out.println("Symbol: " + currency.getSymbol());
            System.out.println("Default fraction digits: " + currency.getDefaultFractionDigits());
            System.out.println();
        }
    }
}