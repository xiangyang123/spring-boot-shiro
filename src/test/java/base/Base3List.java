package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Base3List {

    /**
     * list 分为ArrayList,Vector,LinkedList
     *
     * @param args
     */
//    public static void main(String[] args) {
//        /**
//         * 1.ArrayList 默认容量为10
//         */
//        List aList = new ArrayList() {
//            {
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//                add(1);
//
//            }
//        };
//        System.out.println(11 >> 1);
//
//
//    }

    private static int SIZE = 1111110;

    private static void loopList(List<Integer> list)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i);
        }
        System.out.println(list.getClass().getSimpleName() + "使用普通for循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (Integer i : list)
        {

        }
        System.out.println(list.getClass().getSimpleName() + "使用foreach循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<Integer>(SIZE);
        List<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < SIZE; i++)
        {
            arrayList.add(i);
            linkedList.add(i);
        }

        loopList(arrayList);
//        loopList(linkedList);
        System.out.println();
    }
}


