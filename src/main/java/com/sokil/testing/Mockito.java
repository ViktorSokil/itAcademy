package com.sokil.testing;

import java.util.List;

public class Mockito {
    public void addList(List list, String string){
        list.add(string);
        list.clear();
    }
}
