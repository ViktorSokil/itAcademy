package com.sokil.hw3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicArr {
    public static <T extends Comparable> int countNumbers(T[] arr, T element){
        int count = 0;
        for (T i: arr){
            if (i.compareTo(element) <= -1){
                count++;
            }
        }
        return count;
    }

    public static <T extends Number> List<T> countNumbersSort(Collection<T> collection){
        List<T> list = new ArrayList<T>();
        for (T el: collection){
            list.add(el);
        }
        return list;
    }
}
