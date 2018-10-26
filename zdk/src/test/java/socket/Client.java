package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by z_dk on 2018/10/5.
 */
public class Client {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost",2000);
            //获取输入流与输出流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            //向服务器发送数据
            pw.println("hello");
            String s = null;
            while (true){
                s = br.readLine();
                if(s!=null)
                    break;
            }
            System.out.println(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(socket!=null)
                    socket.close();
                Server.close(br,pw);
            }
            catch (Exception e){

            }
        }
    }
}
