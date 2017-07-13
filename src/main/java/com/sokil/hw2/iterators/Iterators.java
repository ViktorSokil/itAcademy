package com.sokil.hw2.iterators;

import java.util.Set;
import java.util.TreeSet;

public class Iterators {
    public Set<Person> filter(Set<Person> persons, Short age){
        Set<Person> personSet = new TreeSet<Person>();

        for (Person person: persons){
            if (person.getAge() >= age){
                personSet.add(person);
            }
        }
        return personSet;
    }
}
