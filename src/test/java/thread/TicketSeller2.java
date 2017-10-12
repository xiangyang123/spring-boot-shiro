package thread;

import java.util.Vector;

/**
 * Created by zouxiang on 2017/9/30.
 * 即使Vector是同步的，但是size跟remove方法分离会造成线程问题
 *
 */
public class TicketSeller2 {

    static Vector<String> tickets= new Vector<>(10000);
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
                        /**
                         * 加上此代码会出问题
                         */
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("卖出的票号："+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
