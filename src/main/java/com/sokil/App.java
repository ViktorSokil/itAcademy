package com.sokil;

import com.sokil.hw2.queueWrapper.QueueWrapper;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Iterators iterators = new Iterators();
        Person person = new Person("Semen", (short)26);
        Person person1 = new Person("Pety", (short)33);
        Person person2 = new Person("Kukaracha", (short)18);
        Person person3 = new Person("Stepan", (short)24);
        Person person4 = new Person("Shrek", (short)49);
        Person person5 = new Person("Met", (short)15);
        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);
        personSet.add(person5);

        Set<Person> people = iterators.filter(personSet, (short)24);
        for (Person person6: people){
            System.out.println(person6.toString());
        }*/

        QueueWrapper queueWrapper = new QueueWrapper();
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(5);
        queue.add(7);
        List<Integer> list = queueWrapper.asList(queue);
        System.out.println(list);
    }
}
