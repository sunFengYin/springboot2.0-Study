package biomessaging.server;

import biomessaging.util.Contants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Set;

public class ServerReader extends Thread implements Contants {
    private Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                //读取当前的消息类型：登录，群发，私聊
                int flag = dis.readInt();
                if (flag == 1) {
                    String name = dis.readUTF();
                    System.out.println(name + "----->" + socket.getRemoteSocketAddress());
                    ServerChat.onLineSocket.put(socket, name);
                }
                //将消息分发给每个客户
                writeMsg(flag, dis);
            }
        } catch (Exception e) {
            System.out.println("有人下线了");

            ServerChat.onLineSocket.remove(socket);
            try {
                writeMsg(1, dis);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    private void writeMsg(int flag, DataInputStream dis) throws IOException {
        String msg = null;
        if (flag == 1) {
            StringBuilder rs = new StringBuilder();
            Collection<String> onlineNames = ServerChat.onLineSocket.values();
            if (onlineNames != null && onlineNames.size() > 0) {
                for (String name : onlineNames) {
                    rs.append(name + SPILIT);
                }
                msg = rs.substring(0, rs.lastIndexOf(SPILIT));
                sendMsgToAll(flag, msg);
            }
        } else if (flag == 2 || flag == 3) {
            String newMsg = dis.readUTF();
            String sendName = ServerChat.onLineSocket.get(newMsg);

            StringBuilder msgFinal = new StringBuilder();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (flag == 2) {
                msgFinal.append(sendName).append(" ").append(sdf.format(System.currentTimeMillis() * 2)).append("\r\n");
                msgFinal.append("  ").append(newMsg).append("\r\n");
                sendMsgToAll(flag, msgFinal.toString());
            } else if (flag == 3) {
                msgFinal.append(sendName).append("  ").append(sdf.format(System.currentTimeMillis() * 2)).append("对您私发\r\n");
                msgFinal.append("    ").append(newMsg).append("\r\n");
                // 私发
                // 得到给谁私发
                String destName = dis.readUTF();
                sendMsgToOne(destName, msgFinal.toString());
            }
        }
    }

    private void sendMsgToOne(String destName, String msg) throws IOException {
        // 拿到所有的在线socket管道 给这些管道写出消息
        Set<Socket> allOnLineSockets = ServerChat.onLineSocket.keySet();
        for(Socket sk :  allOnLineSockets){
            // 得到当前需要私发的socket
            // 只对这个名字对应的socket私发消息
            if(ServerChat.onLineSocket.get(sk).trim().equals(destName)){
                DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
                dos.writeInt(2); // 消息类型
                dos.writeUTF(msg);
                dos.flush();
            }
        }
    }

    private void sendMsgToAll(int flag, String msg) throws IOException {
        Set<Socket> sockets = ServerChat.onLineSocket.keySet();
        for (Socket sk : sockets) {
            DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
            dos.writeInt(flag);
            dos.writeUTF(msg);
            dos.flush();

        }
    }
}
