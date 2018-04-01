package base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Base4HashMap {

    /**
     * HashMap 默认容量为16，负载因子为0.75
     * HashMap 在JDK1.8上比JDK1.7做了优化，引入了红黑树
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16,0.75f,true);
        linkedHashMap.put("111", "111");
        linkedHashMap.put("222", "222");
        linkedHashMap.put("333", "333");
        linkedHashMap.put("444", "444");
        loopLinkedHashMap(linkedHashMap);
        linkedHashMap.get("111");
        loopLinkedHashMap(linkedHashMap);
        linkedHashMap.put("222", "2222");
        loopLinkedHashMap(linkedHashMap);


        Map<String,Object> map2 = new ConcurrentHashMap<>();
        map2.put("2",2);
    }

    public static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }
}
