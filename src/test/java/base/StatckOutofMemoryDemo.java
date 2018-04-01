package base;

import java.util.ArrayList;
import java.util.List;

public class StatckOutofMemoryDemo {


    public static void main(String[] args) {

        StatckOutofMemoryDemo.add();
    }

    static void add(){
        add();
    }
}
