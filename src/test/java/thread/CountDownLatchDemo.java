package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zouxiang on 2017/9/28.
 * 初体验countDownLatch。调用一次countDown().就减一
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        final int[] index = {0};
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 开始");
                if(index[0] != 5){
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T1 结束");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2 开始");
                while (index[0] <10){
                    index[0] = index[0] + 1;
                    if(index[0] == 5){
                        latch.countDown();
                    }
                }
                System.out.println("T2 结束");
            }
        }).start();
    }
}
