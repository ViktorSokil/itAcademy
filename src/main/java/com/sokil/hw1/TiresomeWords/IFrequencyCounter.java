package com.sokil.hw1.TiresomeWords;

import java.io.FileNotFoundException;

public interface IFrequencyCounter {
    public String[] getMostFrequenctWords(String content, int numberOfwords) throws FileNotFoundException;
}
