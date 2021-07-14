package io.BIO.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream os = socket.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println("你说什么！！");
        printStream.flush();
    }


}
