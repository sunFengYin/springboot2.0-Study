package io.BIO.one;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9999);
            Socket accept = socket.accept();
            InputStream is = accept.getInputStream();
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = bufferedInputStream.readLine()) != null) {
                System.out.println("服务端收到："+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
