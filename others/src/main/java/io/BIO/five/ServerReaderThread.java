package io.BIO.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null){
                sendAllClient(msg);
            }
        } catch (Exception e) {
            System.out.println("当前有人下线了");
            Server.allSocket.remove(socket);
        }

    }

    private void sendAllClient(String msg) throws IOException {
        for (Socket so : Server.allSocket) {
            PrintStream ps = new PrintStream(so.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}
