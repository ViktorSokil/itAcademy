package com.sokil.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * TranslationMap. Написать программу переводчик, которая будет переводить текст, написанный на одном языке, на другой язык согласно заранее составленному словарю.
 */
public class TranslationMap {
    public String reader() throws IOException{
        System.out.println("Input your line: ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        return buf.readLine();
    }
    public void translator(String word, Map<String, String> dictionary) {
        for (String s : word.split(" ")) {
            System.out.print(dictionary.get(s) + " ");
        }
    }
}
