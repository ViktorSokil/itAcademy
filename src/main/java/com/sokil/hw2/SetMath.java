package com.sokil.hw2;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Я on 05.07.2017.
 * 3) SetMath. Напишите класс с методами принимающими два множества и возвращающими другое множество в соответствии с изображением img-cols-1.
 */
public class SetMath {
    public <T> Set<T>  unionSet(Set<T> set, Set<T> set2){
        Set<T> mergeSet = new TreeSet<>();
        mergeSet.addAll(set);
        mergeSet.addAll(set2);
        return mergeSet;
    }

    public <T> Set<T>  intersectionSet(Set<T> set, Set<T> set2){
        Set<T> mergeSet = set;
        mergeSet.retainAll(set2);
        return mergeSet;
    }

    public <T> Set<T>  differenceSet(Set<T> set, Set<T> set2){
        Set<T> tmpSet;
        Set<T> tmpSet2;
        tmpSet = unionSet(set, set2);
        tmpSet2 = intersectionSet(set, set2);
        tmpSet.removeAll(tmpSet2);
        return tmpSet;
    }
}
