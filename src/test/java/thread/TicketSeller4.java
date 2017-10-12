package thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by zouxiang on 2017/9/30.
 *
 * 同步容器
 */
public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();
    static {
        for (int i = 0; i < 10; i++) {
            tickets.add("票号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String s = tickets.poll();
//                        String s = tickets.remove();
                        if (s == null) {
                            break;
                        }else {
                            System.out.println("销售的。。。"+s);
                        }
                    }
                }
            }).start();
        }
    }
}
