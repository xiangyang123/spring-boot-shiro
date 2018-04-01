package base;

import java.util.Arrays;

public class Base2Array {

    public static void main(String[] args) {


        /**
         * StringBuilder 默认容量为16
         * 如果超过StringBuilder默认容量，就是当前StringBuilder字符串长度*2
         *
         * StringBuffer 与StringBuilder容量一致
         */
        StringBuilder b = new StringBuilder();
        b.append("1234567890123456");
        System.out.println("不超过capacity："+b.capacity());
        b.append("1");
        System.out.println("capacity为17个字符："+b.capacity());
        b.append("123456789012345678");
        System.out.println("capacity为35个字符："+b.capacity());

        StringBuffer sb = new StringBuffer();
        sb.append("1234567890123456");
        System.out.println("不超过capacity："+sb.capacity());
        sb.append("1");
        System.out.println("capacity为17个字符："+sb.capacity());
        sb.append("123456789012345678");
        System.out.println("capacity为35个字符："+ sb.capacity());

        /**
         * 数组初始化
         */
        int[] a = new int[1];
        a[0] = 1;

        int[] e = new int[]{1,2};
        System.out.println(e.length+"=="+e[0]+"=="+e[1]);
        int[] f = {1,2};
        System.out.println(f.length+"=="+f[0]+"=="+f[1]);
        /**
         * 当数组没有填满时，默认时数据结构初始值
         */
        int[] c = new int[2];
        c[0] = 2;
        System.out.println(c[0]+"=="+c[1]);

        Integer[] d = new Integer[2];
        d[0] = 1;
        System.out.println(d[0]+"=="+d[1]);
        /**
         * 数组拷贝
         */
        int[] g = Arrays.copyOf(c,c.length);
        Arrays.fill(c,3);
        System.out.println(c.length+"0:"+c[0]+"==1:"+c[1]);
        System.out.println(Arrays.equals(c,g));





    }
}
