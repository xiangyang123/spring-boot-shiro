/**
 * Created by zouxiang on 2017/10/30.
 */
public class LamdbaTest {

    public static void main(String[] args) {
        /*
        List features = new ArrayList();
        features.add("1");
        features.add("2");
        features.forEach(c -> print(c));
        */




//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+": run");
//            }
//        }).start();

        new Thread(() -> print(Thread.currentThread().getName()+": run")).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": d");
    }

    public static void print(Object n){
        System.out.println(n);
    }
}
