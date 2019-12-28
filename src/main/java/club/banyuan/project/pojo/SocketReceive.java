package club.banyuan.project.pojo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReceive extends Thread {
    static File file = null;
    static BufferedInputStream inputStream = null;
    static BufferedOutputStream outputStream=null;
    ServerSocket serverSocket = null;

    {
        file = new File("question.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //单例

    public static volatile SocketReceive socketReceive;
    private SocketReceive(){}
    public static SocketReceive getSocketReceive(){
        if(socketReceive==null){
            synchronized (SocketReceive.class){
                if(socketReceive==null){
                    socketReceive=new SocketReceive();
                }

            }
        }
        return socketReceive;
      }

    @Override
    public void run() {
        receiveMes();
    }

    public synchronized void receiveMes() {
        while (true) {

            try {
                serverSocket = new ServerSocket(1111);

                Socket s = serverSocket.accept();
                inputStream = new BufferedInputStream(s.getInputStream());
                byte[] by = new byte[1000000000];
                int d;
                outputStream = new BufferedOutputStream(new FileOutputStream(file,true));
                while ((d = inputStream.read(by)) != -1) {
                    outputStream.write(by, 0, d);
                    outputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}
