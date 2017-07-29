package com.sokil.testing;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void constructorShouldAmountAndCurrency(){
        Money money = new Money(4000, "UAH");
        Assert.assertEquals(4000, money.getMoney());
        Assert.assertEquals("Constructor has been set currency incorrectly", "UAH", money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldGenerateExceptionWhenAmountIsNegative(){
        Money money1 = new  Money(-10, "UAH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldGenerateExceptionWhenCurrencyIsNull(){
        String invalidNullCurrency = null;
        Money money2 = new Money(2000, invalidNullCurrency);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldGenerateExceptionWhenCurrencyIsEmpty(){
        String invalidEmptyCurrency = "";
        Money money3 = new Money(2000, invalidEmptyCurrency);
    }
}