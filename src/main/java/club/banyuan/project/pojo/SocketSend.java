package club.banyuan.project.pojo;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketSend {
    static Socket socket=null;
    static InputStream inputStream=null;
    static OutputStream outputStream=null;
    static int count=0;
     synchronized String  sendMes(String s1,String s2)  {
        String string=null;
        try {
            socket = new Socket("192.168.11.160", 1234);

            while (count==0) {
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.write((s1+s2).getBytes());
                outputStream.flush();
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[100000];
                int b = inputStream.read(bytes);
                string = new String(bytes, 0, b);
                if(string.equals("成功"))count=1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }



    public static volatile SocketSend socketSend;
    private SocketSend(){}
    public static SocketSend getSocketSend(){
        if(socketSend==null) {
            synchronized (SocketSend.class) {
                if(socketSend==null){
                    socketSend=new SocketSend();
                }
            }
        }
        return socketSend;
    }




}
