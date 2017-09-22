package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zouxiang on 2017/9/21.
 */
public class AQS implements Runnable{

    AtomicInteger count = new AtomicInteger(0);

    public void run(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        AQS a = new AQS();
        for (int i = 0; i < 5; i++) {
            new Thread(a).start();
        }
    }
}
