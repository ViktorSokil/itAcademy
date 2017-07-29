package com.sokil.hw4;

public class StringUtils {
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseEachWordOfString(String inputString)
    {
        String[] words = inputString.split(" ");

        String reverseString = "";

        for (int i = 0; i < words.length-1; i++)
        {
            String word = words[i];

            String reverseWord = reverseString(word);

            reverseString = reverseString + reverseWord + " ";
        }
        reverseString = reverseString + reverseString(words[words.length-1]);

        return reverseString;
    }
}
