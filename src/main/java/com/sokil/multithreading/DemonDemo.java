package com.sokil.multithreading;

public class DemonDemo {
    /*public static void main( String[] args ) throws InterruptedException
    {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread current =  Thread.currentThread();
                // System.out.println(thread.getState());
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    System.out.println(e + " "+ Thread.currentThread().isInterrupted());
                }
                System.out.println(current.getName());
            }
        });

        thread.setDaemon(true); // не має права виходити за рамки jvm (наприкладзаписати файл)

        System.out.println(thread.getState());
        thread.start();
        thread.join(); //почекати завершення потоку (main поток очікує завершення потоків)
        System.out.println("main finished");


        Set set = new TreeSet();
        Set set2 = new TreeSet();

        set.add(1);
        set.add(2);
        set.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(4);
        SetMath setMath=new SetMath();
        System.out.println(setMath.intersectionSet(set, set2).toString());

    }*/
}
