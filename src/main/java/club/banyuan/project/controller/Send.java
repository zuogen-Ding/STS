package club.banyuan.project.controller;

import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;
import club.banyuan.project.util.PojoUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Send {
    static Socket socket;
    static ObjectOutputStream objectOutputStream;
    static ObjectInputStream objectInputStream;
    static InputStream inputStream;


    public static boolean flag() {
        return SendLog.getFlag();
    }


    public static void send(Student object) {
        try {
            socket = new Socket("192.168.11.160", 1111);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            int i = object.getStuTotalScore();
            if (i == 2 || i == 6) {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Student student = (Student)objectInputStream .readObject();
                PojoUtil.setStudent(student);
            }
            if(i==1){
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[10000];
                int b = inputStream.read(bytes);
                String string = null;
                string = new String(bytes, 0, b);
                if (string.equals("登陆")) {
                     SendLog.setFlag(true);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void sendQuestion(Object object) {
        try {
            socket = new Socket("192.168.11.160", 1113);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            PojoUtil.setQuestion((Question) objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
