package javase;

import java.io.*;

/**
 * Created by z_dk on 2018/10/5.
 */
public class Stream {
    public static void main(String[] args) {
//        testStream();
        fileInputtest();
    }

    public static void fileInputtest(){
        try {
            FileInputStream inputStream = new FileInputStream("E:\\文档\\GitHub\\studyGithub\\in.txt");
            FileOutputStream outputStream = new FileOutputStream("E:\\文档\\GitHub\\studyGithub\\out.txt",true);
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer))!=-1)
                outputStream.write(buffer,0,bytesRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testStream(){
        try {
            PrintWriter out = new PrintWriter("E:\\文档\\GitHub\\studyGithub\\a.txt");
            String name = "zhudeng";
            out.print(name);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
