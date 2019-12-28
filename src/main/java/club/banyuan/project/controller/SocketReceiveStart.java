package club.banyuan.project.controller;


import club.banyuan.project.pojo.SocketReceive;
import club.banyuan.project.util.CglibProxy;

public class SocketReceiveStart extends Thread{

    //启动接收服务器

    @Override
    public void run() {
        synchronized (SocketReceiveStart.class) {
            SocketReceive socketReceive = SocketReceive.getSocketReceive();
            CglibProxy c1 = new CglibProxy(socketReceive);
            SocketReceive socketReceive1 = (SocketReceive) c1.getProxy();
            socketReceive1.start();

        }
    }

}
