package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by z_dk on 2018/10/5.
 */
public class Server {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(2000);
            Socket socket = server.accept();
            //获取输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取输出流
            pw = new PrintWriter(socket.getOutputStream());
            String s = br.readLine();//获取接收数据
            pw.print(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(br,pw);
            if(server!=null)
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static void close(BufferedReader br,PrintWriter pw){
        try {
            if (br!=null)
                br.close();
            if (pw!=null)
                pw.close();
        }
        catch (Exception e){

        }
    }
}
