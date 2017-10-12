package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zouxiang on 2017/9/29.
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("T1 开始");
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        System.out.println(i);
                    }
                    System.out.println("T1 结束");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

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

                boolean locked = false;
                try {
                    locked = lock.tryLock(5, TimeUnit.SECONDS);
                    System.out.println(locked);
                    if(locked){
                        try {
                            System.out.println("T2 结束");
                        }catch (Exception e){

                        }finally {
                            lock.unlock();
                        }

                    }else{
                        System.out.println("未获得锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
}
