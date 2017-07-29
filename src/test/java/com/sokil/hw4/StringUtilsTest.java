package com.sokil.hw4;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testReverseString(){
        String rightString = "12345";
        String rightResultString = StringUtils.reverseString(rightString);
        Assert.assertEquals("54321", rightResultString);
    }

    @Test
    public void testReverseEachWordOfString(){
        String rightString = "Ola  245ab0";
        String rightResultString = StringUtils.reverseEachWordOfString(rightString);
        Assert.assertEquals("alO  0ba542", rightResultString);
    }
}
