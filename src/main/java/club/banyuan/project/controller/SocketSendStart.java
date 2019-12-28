package club.banyuan.project.controller;

import club.banyuan.project.pojo.SocketSend;
import club.banyuan.project.util.CglibProxy;

public class SocketSendStart extends Thread {

    //启动发送
    public void run() {
        synchronized (SocketSendStart.class) {
            SocketSend socketSend = SocketSend.getSocketSend();
            CglibProxy c2 = new CglibProxy(socketSend);
            SocketSend socketSend1 = (SocketSend) c2.getProxy();
            socketSend1.start();
        }
    }
}
