package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouxiang on 2017/9/30.
 */
public class TicketSeller1 {

    static List<String> tickets= new ArrayList<>(10000);
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (tickets.size() > 0){
                        System.out.println("卖出的票号："+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
