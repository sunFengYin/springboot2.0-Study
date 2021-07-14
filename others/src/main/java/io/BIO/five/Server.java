package io.BIO.five;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static List<Socket> allSocket;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);

            while(true){
                Socket socket = ss.accept();

                allSocket.add(socket);

                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
