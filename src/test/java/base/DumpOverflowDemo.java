package base;

import java.util.ArrayList;
import java.util.List;

public class DumpOverflowDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (long i = 0; i < 10000000000000L; i++) {
            Person person = new Person();
            list.add(person);
        }
    }

    static class Person{

    }
}
