package com.sokil.hw2.iterators;

import java.util.Set;
import java.util.TreeSet;

public class Iterators {
    public Set<Person> filter(Set<Person> persons, Short age){
        Set<Person> personSet = new TreeSet<Person>();

        for (Person person: persons){
            /*Integer occurances = hashMap.get(person);
            hashMap.put(element, occurances == null ? 1: occurances+1);*/
            if (person.getAge() >= age){
                personSet.add(person);
            }
        }
        return personSet;
    }
}
