package club.banyuan.project.controller;

import club.banyuan.project.pojo.Admin;
import club.banyuan.project.service.AdminService;
import club.banyuan.project.service.impl.AdminServiceImpl;
import club.banyuan.project.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveAdm {
    static ServerSocket serverSocket1;
    static OutputStream outputStream1;
    static ObjectInputStream objectInputStream1;
    public static void main(String[] args) {

        try {
            serverSocket1 = new ServerSocket(1112);

            while (true) {
                Socket s = serverSocket1.accept();

                objectInputStream1 = new ObjectInputStream(s.getInputStream());
                Admin admin = (Admin) objectInputStream1.readObject();
                String string1 = admin.getAdmName();
                String string2 = admin.getAdmPassword();
                int i=admin.getFlag();
                if(i==0) {
                    outputStream1 = s.getOutputStream();
                    if (AdminServiceImpl.getAdminServiceImpl().commit(string1, string2)) {
                        outputStream1.write("登陆".getBytes());
                    } else {
                        outputStream1.write("失败".getBytes());
                    }
                    outputStream1.flush();
                }
                if(i==1){
                    AdminServiceImpl.getAdminServiceImpl().setAdmin(string1,string2);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
