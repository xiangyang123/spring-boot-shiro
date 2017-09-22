package thread;

/**
 * Created by zouxiang on 2017/9/21.
 * 线程同步问题
 */
public class Syn implements Runnable{

    private int count = 10;

    @Override
    public void run() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
        Syn syn = new Syn();
        for (int i = 0; i < 5; i++) {
            new Thread(syn,"Thread:"+i).start();
        }
    }
}
