package javase;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by z_dk on 2018/10/2.
 */
public class BigEndian {
    protected String testpro = "protected";
    public static void main(String[] args) {
//      stringtest();
//      mathtest();
//        lambdatest();
//        System.out.println(stringtest(2));
//        bigdecimaltest();
//        stringtest3();
        /*try {
            gb2312();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
//        memerytest();
//        List<Integer> ids = new ArrayList<>();
//        testMath();
//        qianji();
        dayincfb();
    }
    public static void memerytest(){
        //jvm中空闲内存量（单位：字节）
        System.out.println(Runtime.getRuntime().freeMemory());
        //jvm内存总量
        System.out.println(Runtime.getRuntime().totalMemory());
        //jvm试图使用的最大内存
        System.out.println(Runtime.getRuntime().maxMemory());
        //可用处理器数目
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public static void gb2312() throws Exception {
        String gb = new String("中国".getBytes(),"utf-8");
        System.out.println(gb);
        String ios = new String(gb.getBytes("utf-8"),"ISO-8859-1");
        System.out.println(ios);
        gb = new String(ios.getBytes("ISO-8859-1"),"utf-8");
        System.out.println(gb);
    }
    public static void stringtest3(){
        String s = "你好";
        int i = (s!=null)&&(s.length()>0)?s.length():0;
        int j = 3;

        s += j;
        System.out.println(s);
    }
    public static void change(StringBuffer str){
        str.append("test ok");
    }
    public static void stringtest2(){
        StringBuffer str = new StringBuffer("good");
        char[]ch = {'a','b','c'};
        change(str);
        //str+="world";
        System.out.println(str);
        System.out.println(ch);
    }
    public static void bigdecimaltest(){
        double d1 = 2.15;
        double d2 = 1.10;
//        System.out.println("double:"+(d1-d2));
        BigDecimal bd1 = new BigDecimal("2.15");
        BigDecimal bd2 = new BigDecimal("1.10");
//        System.out.println("bigdecimal:"+bd1.subtract(bd2));
//        System.out.println(Long.MAX_VALUE);
        byte b = (byte)129;
        byte b2 = -0b10000000;
        String binaryString = Integer.toBinaryString(b);
        System.out.println(b+" "+binaryString);
        System.out.println(b2);
        short s1 = 1;
        short s2 = 2;
        int i = 1;
//        System.out.println("short"+(s1+=i));
//        System.out.println("short"+(s1=(short) (s1+i)));
    }
    public void bigendiantest(){
        byte[] attr = new byte[4];
        attr[0] = 0x78;
        attr[1] = 0x56;
        attr[2] = 0x34;
        attr[3] = 0x12;
        ByteArrayInputStream bais = new ByteArrayInputStream(attr);
        DataInputStream dis = new DataInputStream(bais);
        try {
            System.out.println(Integer.toHexString(dis.readInt()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void stringtest(){
        String gotot = new String("goto");
//      gotot = "goodkok";
        Object ob = new Object();

        System.out.println(gotot);
    }
    public static int stringtest(int i){
        return i;
    }
    public static void mathtest(){
        float a = 12.5f;
        double b = -12.6;
        int binary = 0b1001;
        System.out.println(Math.round(a));
        System.out.println(Math.round(b));
        System.out.println(Math.round(binary));
    }
    public static void lambdatest(){
        int b = 0;
        int a = 9;
        Integer as[] = {1,2,3,6,3,2};
        Arrays.sort(as);
        List<Integer> integers = Arrays.asList(as);
        integers.forEach((i)-> System.out.println(i));
//        Arrays.asList(2,5,3,9).forEach(i-> System.out.println(i));
    }
    public static void testMath(){
        double a = 12.5;
        System.out.println(Math.round(a));
        System.out.println(Math.ceil(a));
        System.out.println(Math.floor(a));
    }
    public static void qianji(){
        for(int i = 0;i<33;i++){
            muji:for(int j=0;j<100-i;j++){
                if(i+j+(100-3*i-2*j)*3==100) {
                    System.out.print("公鸡个数为：" + i);
                    System.out.print("母鸡个数为：" + j);
                    System.out.println("小鸡个数为：" + (100 - i - j));
                    break muji;
                }
            }
        }
    }
    public static void dayincfb(){
        for (int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println("");
        }
    }
    public static void zishu(){
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        if (num%2!=0){
            System.out.println("不是偶数，请重新输入1");
        }
        else {
            //实现偶数分解为两个质数相加
        }
    }
}
