package thread;

/**
 * Created by zouxiang on 2017/9/30.
 */
public class Singleton {

    private Singleton(){

    }

    private static class Inner{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstince(){
        return Inner.singleton;
    }


}
