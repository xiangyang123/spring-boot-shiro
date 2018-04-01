package base;

import java.util.concurrent.*;

/**
 * 学习线程
 * 1。创建线程的方式有哪些？
 */
public class Base5Thread{

    private static int i= 0;

    /**
     * 1.继承extends Thread
     */
    static class ExtendsThread extends Thread{
        @Override
        public void run() {
            while (i < 5){
                System.out.println("Thread: "+Thread.currentThread().getName()+"==="+i);
                i++;
            }
        }
    }

    /**
     * 2.实现Runnable接口
     */
    static class ImpRunable implements Runnable{
        @Override
        public void run() {
            while (i < 5){
                System.out.println("Runnable: "+Thread.currentThread().getName()+"==="+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }


    public static void main(String[] args) throws Exception{

//        ExtendsThread extendsTHread = new ExtendsThread();
//        extendsTHread.start();
//
//
//        new Thread(new ImpRunable()).start();
//
//
        ExecutorService executorService = Executors.newFixedThreadPool(30);
//        ExecutorService executorService = Executors.
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("notify start");
                    this.notifyAll();
                    System.out.println("notify end");

                    while (i < 5) {

                        System.out.println("ExecutorService execute: " + Thread.currentThread().getName() + "===" + i);
                        i++;
                    }
                }
            }
        });

        Future<String> future =  executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                synchronized (this) {
                    System.out.println("wait start");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait end");
                    while (i < 5) {

                        Thread.sleep(100);
                        System.out.println("ExecutorService submit: " + Thread.currentThread().getName() + "===" + i);
                        i++;
                    }
                    return "mobile";
                }
            }
        });
            System.out.println(future.get());
        executorService.shutdown();
    }
}
