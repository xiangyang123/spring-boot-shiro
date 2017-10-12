package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zouxiang on 2017/9/30.
 */
public class BlockQueue1 {

    static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);//无界阻塞队列

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            blockingQueue.put(""+i);
        }
        System.out.println(blockingQueue.size());
        System.out.println(blockingQueue.offer("9"));
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.size());
        blockingQueue.put("11");//如果满了则会等待
        blockingQueue.take();//如果空了则会等待
    }
}
