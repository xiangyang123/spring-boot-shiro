package base;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Base7File {

    public static void main(String[] args) {
        Comparator comparator = Collections.reverseOrder();
        Set<Integer> set = new TreeSet<>(comparator);
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);

//        List<Integer> list = new ArrayList<>();
//        Collections.sort(set, Collections.reverseOrder());
        System.out.println("倒叙："+set);
        Base7File.add();
    }

    public static synchronized void add(){

    }
}
