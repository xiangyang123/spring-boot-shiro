package base;

import org.elasticsearch.search.DocValueFormat;

/**
 * 基础1:jdk 1.8
 * 基础类型byte short int long float double char boolean类型必须初始化
 * 包装类Byte Short Integer
 */
public class Base1 {

    private final int p = 100;

    public static void main(String[] args) {
        /**
         * char 占2个byte。16bit 可以存1个中文
         */
        char b = '中';
        System.out.println(b);
        /**
         * 低级---》高级 隐式转换
         *
         */
        int a = 100;
        long c = a;
        System.out.println("隐式转换： "+a+"==="+c);

        /**
         * 高级---》低级 隐式转换
         *
         */
        long d = 100L;
        int e = (int) d;
        System.out.println("显示转换："+d+"==="+e);

        /**
         * 自动装箱
         */
        int f  = 100;
        Integer g = f;
        System.out.println("自动装箱："+f+"==="+g);
        /**
         * 自动拆箱
         */
        Long h = new Long(100);
        long m = h;
        System.out.println("自动拆箱："+h+"==="+m);
        System.out.println(Math.floor(-100.6));


        double n = 99/2;
        System.out.println("精度丢失: "+n);

        /**
         * final 修饰的常量不可重新赋值
         * final 修饰的方法不可重写Override
         * final 修饰的class，不可被继承
         */

        /**
         * trim() 方法仅仅去掉收尾空格
         */
        String q = "  a bcc   dd   ";
        System.out.println(q.trim());


        /**
         * 跳出循环break
         */
        for (int i=0;i<10;i++) {
            System.out.println("i=: "+i);
            for (int j = 0; j < 5; j++) {
                System.out.println("j=: "+j);
                if(i==5){
                    break;
                }
            }

        }

//        System.out.println("继续第二个");
//        for (int i=0;i<10;i++) {
//            System.out.println("i=: "+i);
//            if(i==5){
//                return;
//            }
//        }
//        System.out.println("继续第三个");
//        flag:
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i=: "+i);
//            for (int j = 0; j < 5; j++) {
//                System.out.println("j=: "+j);
//                if(i==5){
//                    break flag;
//                }
//            }
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i=: "+i);
//            for (int j = 0; j < 5; j++) {
//                System.out.println("j=: "+j);
//                if(i==5){
//                    double r = 5/0;
//                }
//            }
//        }
        System.out.println("end");


    }



}
