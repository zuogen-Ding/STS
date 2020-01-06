package club.banyuan.project.controller;


import club.banyuan.project.pojo.Student;
import club.banyuan.project.service.impl.AdminServiceImpl;
import club.banyuan.project.service.impl.StudentServiceImpl;
import club.banyuan.project.util.ServiceStu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveStu {
    static ServerSocket serverSocket1;
    static OutputStream outputStream1;
    static ObjectInputStream objectInputStream1;
    static ObjectOutputStream objectOutputStream;

    static String string2 = null;
    static String string1 = null;
    static int flag;
    static int num;
    static int java;
    static int python;
    static int databases;

    public static void main(String[] args) {

        try {
            serverSocket1 = new ServerSocket(1111);

            while (true) {
                Socket s = serverSocket1.accept();
                objectInputStream1 = new ObjectInputStream(s.getInputStream());
                Student student = (Student) objectInputStream1.readObject();
                flag = student.getStuTotalScore();
                if(flag==0){
                    num=student.getStuNum();
                    AdminServiceImpl.getAdminServiceImpl().delStu(num);
                }
                if (flag == 1) {
                    string1 = student.getStuName();
                    string2 = student.getStuPassword();
                    login(string1, string2, s);
                }
                if (flag == 2) {
                    string1 = student.getStuName();
                    objectOutputStream=new ObjectOutputStream(s.getOutputStream());
                    objectOutputStream.writeObject(StudentServiceImpl.getStudentService().getScore(string1));
                    objectOutputStream.flush();
                }
                if(flag==3){
                    string1 = student.getStuName();
                    string2 = student.getStuPassword();
                    StudentServiceImpl.getStudentService().modifyPwd(string1,string2);
                }
                if (flag == 4) {
                    num=student.getStuNum();
                    string1=student.getStuName();
                    AdminServiceImpl.getAdminServiceImpl().updateStu(num,string1);
                }
                if(flag==5){
                    java=student.getJava();
                    python=student.getPython();
                    databases=student.getDatabase();
                    string1=student.getStuName();
                    StudentServiceImpl.getStudentService().input(java,databases,python,string1);
                }
                if(flag==6){
                    num=student.getStuNum();
                    Student student1= AdminServiceImpl.getAdminServiceImpl().selStu(num);
                    objectOutputStream=new ObjectOutputStream(s.getOutputStream());
                    objectOutputStream.writeObject(student1);
                    objectOutputStream.flush();
                }if(flag==7){
                    num=student.getStuNum();
                    string1=student.getStuName();
                    AdminServiceImpl.getAdminServiceImpl().addStu(num,string1);
                }if(flag==8){
                    string1 = student.getStuName();
                    string2 = student.getStuPassword();
                    StudentServiceImpl.getStudentService().update(string1,string2);
                }


            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream1.close();
                serverSocket1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void login(String s1, String s2, Socket s) {
        try {
            outputStream1 = s.getOutputStream();
            if (StudentServiceImpl.getStudentService().login(s1, s2)) {
                outputStream1.write("登陆".getBytes());
            } else {
                outputStream1.write("失败".getBytes());
            }
            outputStream1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
