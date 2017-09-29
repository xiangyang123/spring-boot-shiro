package thread;

/**
 * Created by zouxiang on 2017/9/27.
 *
 * 线程之间如果不做处理的话，线程执行的顺序是不确定的。
 * join wait 造成死锁
 */
public class ThreadDemo {

    final static ThreadDemo threadDemo = new ThreadDemo();

    static Thread t1 = new Thread(new Runnable() {

        int index = 0;
        @Override
        public void run() {
            System.out.println("T1");
            synchronized (threadDemo) {
//                    while (index < 5) {
//                        index = threadDemo.add(index);
//                    }
                System.out.println("T1 start");
                try {
                    threadDemo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end");
            }
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                t1.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("T2");
            synchronized (threadDemo){
                System.out.println("T2 start");
                try {
                    threadDemo.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end");
            }

        }
    });

    public static void main(String[] args) throws Exception {
        t1.start();
        t2.start();




//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (threadDemo){
//                    try {
//                        threadDemo.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    threadDemo.over();
//                }
//
//            }
//        }).start();
    }


    public int add(int index){
        index  = index + 1;
        System.out.println(Thread.currentThread()+"index: "+index);
        return index;
    }


    public void over(){
        System.out.println(Thread.currentThread()+"over");
    }


}
