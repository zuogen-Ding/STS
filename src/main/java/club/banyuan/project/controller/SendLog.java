package club.banyuan.project.controller;

import club.banyuan.project.pojo.Admin;
import club.banyuan.project.pojo.Student;
import com.sun.tools.internal.ws.wsdl.document.Port;

import javax.rmi.CORBA.Stub;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendLog {
    static Socket socket;
    static ObjectOutputStream objectOutputStream;
    static InputStream inputStream;
    static boolean flag = false;


    public static void send(Admin admin) {
        try {
            socket = new Socket("192.168.11.160", 1112);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(admin);
            objectOutputStream.flush();
            int i = admin.getFlag();
            if (i == 0) {
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[10000];
                int b = inputStream.read(bytes);
                String string = null;
                string = new String(bytes, 0, b);
                if (string.equals("登陆")) {
                    flag = true;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean getFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        SendLog.flag = flag;
    }
}

