package javase;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
        try {
            gb2312();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        System.out.println("double:"+(d1-d2));
        BigDecimal bd1 = new BigDecimal("2.15");
        BigDecimal bd2 = new BigDecimal("1.10");
        System.out.println("bigdecimal:"+bd1.subtract(bd2));
        System.out.println(Long.MAX_VALUE);
        byte b = 0b1111111;
        System.out.println(b);
        short s1 = 1;
        short s2 = 2;
        int i = 1;
        System.out.println("short"+(s1+=i));
        System.out.println("short"+(s1=(short) (s1+i)));
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
    @Test
    public void junittest(){
        System.out.println("junit测试!");
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
}
