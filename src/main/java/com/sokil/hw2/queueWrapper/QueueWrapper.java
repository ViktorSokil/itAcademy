package com.sokil.hw2.queueWrapper;

import java.util.*;

public class QueueWrapper {
    public <T> List<T> asList(Queue<T> queue){
        return  Collections.unmodifiableList(new ArrayList<>(queue));
    }
}
