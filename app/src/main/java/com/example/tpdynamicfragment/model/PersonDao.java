package com.example.tpdynamicfragment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDao {
    static int incId = 0;
    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person(++incId, "PHAM", "Thang", "01/10/1981"));
        personList.add(new Person(++incId, "PHAM", "Alexandre", "10/08/2014"));
        personList.add(new Person(++incId, "PHAM", "Louis", "30/09/2015"));
        personList.add(new Person(++incId, "TRINH", "Mai", "26/08/1989"));
    }

    public static List<Person> getPersons() {
        return Collections.unmodifiableList(personList);
    }
}
