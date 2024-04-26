package org.atique.java.functionalprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author atiQue
 * @since 26-Apr-24 12:26 PM
 */

public class MethodReferenceDemo {
    public static void main(String[] args) {
        //Shortcut of: Supplier<Double> supplier = () -> Math.random();
        Supplier<Double> supplier = Math::random;

        //Shortcut of: Function<Person, String> function = (person) -> person.getName();
        Function<Person, String> function = Person::getName;

        Person p1 = new Person("p1");
        Person p2 = new Person("p2");

        //Shortcut of: BiPredicate<Person, Person> isEqual = (per1, per2) -> per1.equals(per2);
        BiPredicate<Person, Person> isEqual = Person::equals; //or, Object::equals;

        //Shortcut of: Function<List<String>, Integer> getSize = (list) -> list.size();
        Function<List<String>, Integer> getSize = List::size;
        //or,
        Function<ArrayList<String>, Integer> getSize2 = ArrayList::size;

        //We can call the constructor also, for example we want to dedup a List and get an Set
        //Shortcut of: Function<List<String>, Collection<String>> deDup = (list) -> new HashSet<>(list);
        Function<List<String>, Collection<String>> deDup = HashSet::new;
    }
}

class Person {
    public String getName() {
        return name;
    }

    private String name;

    Person(String name) {
        this.name = name;
    }
}
