package com.sokil.hw2;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayQueue<T>{

    private static final int DEFAULT_CAPACITY = 3;
    private int head;
    private int tail;
    T[] arrayQueue;

    public MyArrayQueue() {
        head = tail = 0;
        arrayQueue = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public MyArrayQueue(int capacity) {
        head = tail = 0;
        arrayQueue = (T[])(new Object[capacity]);
    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean contains(T el) {
        for (int i=0; i<arrayQueue.length; i++){
            if (arrayQueue[i] == el) {
                return true;
            }
        }
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public T[] toArray() {
        return Arrays.copyOf(arrayQueue, size());
    }

    public boolean offer(T el) {
        if (isEmpty())
        if (isFull()){
            increaseCapacity();
        }
        if (head != 0 && tail == arrayQueue.length-1){
            shiftElement();
        }
        arrayQueue[tail] = el;
        tail++;
        return true;
    }

    public T remove() {
        T result = null;
        if (isEmpty()){
            return null;
        }else {
            result = arrayQueue[head];
            arrayQueue[head] = null;
            head ++;
        }
        return result;
    }

    public T element() {
        T result = null;
        if (isEmpty()){
            return null;
        }else {
            result = arrayQueue[head];
        }
        return result;
    }

    @Override
    public String toString() {
        return "MyArrayQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", arrayQueue=" + Arrays.toString(arrayQueue) +
                '}';
    }

    public T getHead() {
        return arrayQueue[head];
    }

    public T getTail() {
        return arrayQueue[tail-1];
    }

    private void increaseCapacity (){
        T[]largeQueue = (T[])(new Object[size()*2]);

        System.arraycopy(arrayQueue, 0, largeQueue, 0, arrayQueue.length);
        arrayQueue = largeQueue;
    }

    private boolean isFull(){
        return arrayQueue.length == size();
    }

    private void shiftElement() {
        T[] arrTemp = (T[])(new Object[arrayQueue.length]);
        System.arraycopy(arrayQueue, head, arrTemp, 0, arrayQueue.length);
        arrayQueue = arrTemp;
        tail = tail - head;
        head = 0;
    }
}
