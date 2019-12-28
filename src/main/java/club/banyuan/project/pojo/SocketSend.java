package club.banyuan.project.pojo;

import java.io.*;

import java.net.Socket;

public class SocketSend extends Thread{
    static BufferedInputStream bufferedInputStream =null;
    static BufferedOutputStream bufferedOutputStream =null;
    static File file=null;


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

    @Override
    public void run() {
        try {
            sendMes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


      static synchronized void sendMes() throws IOException {

            byte[] by = new byte[(int) file.length()];
            Socket socket = new Socket("192.168.11.160", 1111);
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            int d;
            while((d= bufferedInputStream.read(by,0,by.length))!=-1){
                bufferedOutputStream.write(by,0,d);
                bufferedOutputStream.flush();
            }
            socket.shutdownOutput();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            socket.close();

    }
}
