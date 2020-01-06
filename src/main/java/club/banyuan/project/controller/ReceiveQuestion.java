package club.banyuan.project.controller;

import club.banyuan.project.pojo.Question;
import club.banyuan.project.service.StudentService;
import club.banyuan.project.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveQuestion {
    static ServerSocket serverSocket1;
    static ObjectOutputStream objectOutputStream;
    static ObjectInputStream objectInputStream1;

    public static void main(String[] args) {

        try {
            serverSocket1 = new ServerSocket(1113);
            Socket s;
            while (true) {
                s = serverSocket1.accept();
                objectInputStream1 = new ObjectInputStream(s.getInputStream());
                Question question = (Question) objectInputStream1.readObject();
                String string1 = question.getQueName();
                question = StudentServiceImpl.getStudentService().exam(string1);
                objectOutputStream = new ObjectOutputStream(s.getOutputStream());
                objectOutputStream.writeObject(question);
                objectOutputStream.flush();
                objectOutputStream.close();
                objectInputStream1.close();

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
