package com.sokil.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericCast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = (LinkedList<String>)list; //RTE ClassCastException but in CTE OK
        System.out.println(list1);
    }

}
