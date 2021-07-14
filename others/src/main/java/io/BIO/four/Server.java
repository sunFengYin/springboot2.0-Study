package io.BIO.four;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *伪异步通信
 */
public class Server {
    public static void main(String[] args) {
        try{
            //1。注册端口
            ServerSocket ss = new ServerSocket(9999);
            //2.定义一个循环接收客户端的socket链接请求
            HandlerSocketServerPool pool = new HandlerSocketServerPool(6, 10);
            while(true){
                Socket socket = ss.accept();
                //3。把socket对象交给一个线程池进行处理

                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
