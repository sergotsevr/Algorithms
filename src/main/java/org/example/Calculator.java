package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculator {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person(12, "fff");
        Person p2 = new Person(22, "2ff");
        Person p3 = new Person(32, "3ff");
        people.add(p1);
        people.add(p2);
        people.add(p3);

        for (Person p : people) {
            if (p.name().equals("fff")) {
                people.remove(p);
            }
        }
        System.out.println(people);
    }

}