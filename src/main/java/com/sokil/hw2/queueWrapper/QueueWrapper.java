package com.sokil.hw2.queueWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueWrapper {
    public List asList(Queue queue){
        List list = new ArrayList();
        while (queue.poll()!= null){
            list.add(queue.peek());
        }
        return list;
    }
}
