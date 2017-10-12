package thread;

import java.util.LinkedList;

/**
 * Created by zouxiang on 2017/9/29.
 */
public class MyContainer<T> {
    LinkedList<T> list =new LinkedList<>();
    public static int MAX = 10;//最大容量
    public int count = 0;//最开始的时候的容量

    public synchronized void put(T t){
        System.out.println("size: "+getCount());
        while(list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        --count;
        this.notifyAll();
        return t;
    }

    public synchronized int getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        final MyContainer myContainer = new MyContainer();
        //创建10个消费者
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                    System.out.println(myContainer.get());
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 创建2个生产者
         */
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("p: "+Thread.currentThread().getName());
                        myContainer.put(Thread.currentThread().getName());
                    }
                }
            }).start();
        }
    }

}
