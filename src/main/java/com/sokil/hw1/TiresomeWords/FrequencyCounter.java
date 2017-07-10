package com.sokil.hw1.TiresomeWords;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter implements IFrequencyCounter {

    private class Frequency{

        private Frequency(){
            this.count = 1;
        }

        private int count;

        public int getFrequency(){
            return this.count;
        }

        public void incrementFrequency(){
            this.count++;
        }

        public void setCount(int count){
            this.count = count;
        }
    }

    /**
     * Класс токена расширяет частоту. Это
           * Используется для поддержания отношения частоты слов.
           * (Как пара.)
     */
    private class Token extends Frequency{

        private Token(String word, int count){
            super();
            this.word = word;
            setCount(count);
        }

        private String word;
    }

    /**
     * This method returns String array sorted by most frequent word. If null/empty     string
     * is provided as input then empty array is returned. If numberOfWords is greater then
     * unique words then all the words are returned.
     *
     */
    @Override
    public String[] getMostFrequenctWords(String path, int numberOfwords) throws FileNotFoundException {
        // basic validations
        String content = read(path);
        if( null == content) content = "";
        if(numberOfwords <= 0) return new String[0];
        int maxSofar = 0;
        HashMap<String,Frequency> wordMap = new HashMap<String,Frequency>();

        String[] contentArray = content.split("\\s+");
        addWordsToMap(contentArray, wordMap);
        return getSortedArray(numberOfwords, maxSofar, wordMap);
    }

    /**
     * returns sorted array of words(String) in decreasing order of frequency.

     */
    private String[] getSortedArray(int numberOfwords, int maxSofar, Map<String, Frequency> wordMap) {
        String[] mostFreqWordsArr;
        int i =0;
        Token[] wordsArr = new Token[wordMap.keySet().size()];

        for (String key : wordMap.keySet()) {
            wordsArr[i++] = new Token(key, wordMap.get(key).getFrequency());
            if(maxSofar < wordMap.get(key).getFrequency()){
                maxSofar = wordMap.get(key).getFrequency();
            }
        }

        wordMap = null; // just to free memory in case input is a very large string
        int[] frequencyArr = new int[maxSofar+1];
        String[] stringArr = new String[wordsArr.length];

        for(i =0; i<wordsArr.length; i++)       frequencyArr[wordsArr[i].getFrequency()] += 1;
        for(i =1; i<frequencyArr.length; i++)   frequencyArr[i] += frequencyArr[i-1];
        for(i= 0; i<wordsArr.length; i++)   {
            stringArr[frequencyArr[wordsArr[i].getFrequency()]-1] =  wordsArr[i].word;
            frequencyArr[wordsArr[i].getFrequency()] -=1;
        }

        if(stringArr.length-numberOfwords >= 0)
            mostFreqWordsArr = Arrays.copyOfRange(stringArr, stringArr.length-numberOfwords, stringArr.length);
        else
            mostFreqWordsArr = Arrays.copyOfRange(stringArr, 0, stringArr.length);

// reverse the string so most frequent words come first
        for(i = 0; i < mostFreqWordsArr.length / 2; i++){
            String temp = mostFreqWordsArr[i];
            mostFreqWordsArr[i] = mostFreqWordsArr[mostFreqWordsArr.length-1 - i];
            mostFreqWordsArr[mostFreqWordsArr.length-1 - i] = temp;
        }
        return mostFreqWordsArr;
    }

    /**
     * @param contentArray
     * @param wordMap
     */
    private void addWordsToMap(String[] contentArray, Map<String, Frequency> wordMap) {
        for (String string : contentArray) {
            if(wordMap.containsKey(string)){
                wordMap.get(string).incrementFrequency();
            }else {
                Frequency token = new Frequency();
                wordMap.put(string,token);
            }
        }
    }

    private static String read(String path) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();



        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( path));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}
