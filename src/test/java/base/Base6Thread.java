package base;

public class Base6Thread extends Thread{

    @Override
    public void run() {
//        long beginTime=System.currentTimeMillis();
//        int count=0;
//        for (int i=0;i<50;i++){
//            count=count+(i+1);
////            Thread.yield();
//            System.out.println(count);
//        }
//        long endTime=System.currentTimeMillis();
//        System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
        System.out.println(Thread.currentThread().getName()+"====="+this.getPriority());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        Base6Thread t= new Base6Thread();
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
        Thread.sleep(100);
        Base6Thread t2= new Base6Thread();
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        Base6Thread t3= new Base6Thread();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
//        System.out.println("begin: "+t.isAlive());
//        t.start();
//        System.out.println("end: "+t.isAlive());

    }
}
