package com.sokil.hw2.queueWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueWrapper {
    public <T> List<T> asList(Queue<T> queue){
        List<T> list = new ArrayList<>(queue);
        return  list;
    }
}
