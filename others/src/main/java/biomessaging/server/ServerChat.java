package biomessaging.server;

import biomessaging.util.Contants;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerChat implements Contants {
    public static Map<Socket,String> onLineSocket=new HashMap<>();

    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(POST);
            while(true){
                Socket socket = ss.accept();

                new ServerReader(socket).run();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
