package club.banyuan.project.pojo;

import club.banyuan.project.dao.StudentDao;
import club.banyuan.project.dao.impl.StudentDaoImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReceive extends Thread {
    static ServerSocket serverSocket = null;
    static OutputStream outputStream = null;
    static ObjectInputStream objectInputStream = null;

    //单例

    public static volatile SocketReceive socketReceive;

    private SocketReceive() {
    }

    public static SocketReceive getSocketReceive() {
        if (socketReceive == null) {
            synchronized (SocketReceive.class) {
                if (socketReceive == null) {
                    socketReceive = new SocketReceive();
                }

            }
        }
        return socketReceive;
    }


    static synchronized void receiveMes() {
        try {
            serverSocket = new ServerSocket(1234);

            while (true) {
                Socket s = serverSocket.accept();
                objectInputStream = new ObjectInputStream(s.getInputStream());
                Student student = (Student) objectInputStream.readObject();
                String string1 = student.getStuName();
                String string2 = student.getStuPassword();
                String string = StudentDaoImpl.getSocketReceive().commitInfo(string1);
                outputStream = s.getOutputStream();
                String str="失败";
                if (string.equals(string2)) str="成功";
                outputStream.write(str.getBytes());
                outputStream.flush();

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


