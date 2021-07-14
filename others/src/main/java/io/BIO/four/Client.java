package io.BIO.four;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 9999);

            PrintStream ps=new PrintStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("=============");
                String s = scanner.nextLine();
                ps.println(s);
                ps.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
