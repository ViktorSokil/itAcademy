package com.sokil.testing;

public final class Money {
    final int amount;
    final String currency;

    public Money(int amount, String currency) {
        if (amount < 0){
            throw new IllegalArgumentException();
        }
        if (currency == null || currency.equals("")){
            throw new IllegalArgumentException();
        }
        this.amount = amount;
        this.currency = currency;
    }

    public int getMoney() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }


}
