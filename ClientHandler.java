package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    public String getName() {
        return name;
    }
    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    while (true) { // цикл авторизации
                        long a=0;
                        String str = in.readUTF();
a=a+System.currentTimeMillis();
if (a>=120000){
    myServer.unsubscribe(this);

    try {
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
                      if (str.startsWith("/auth")) {
                            String[] parts = str.split("-");
                            System.out.println(parts[0]);
                        System.out.println(parts[1]);
                            String nick = myServer.getAuthService().getNickByLoginPass(parts[0], parts[1]);
                            if (nick != null) {
                              //  if (!myServer.isNickBusy(nick)) {
                                    sendMsg("authok " + nick);
                                    name = nick;
                                    myServer.broadcastMsg(name + " зашел в чат");
                                    myServer.subscribe(this);
                                    break;
                               } else sendMsg("Учетная запись уже используется");
                            } else {
                                sendMsg("Неверные логин/пароль");
                            }
                       // }
                    }
                    while (true) { // цикл получения сообщений
                     //   String str = in.readUTF();
                     //   System.out.println("от " + name + ": " + str);
                     //   if (str.equals("/end")) break;
                     //   myServer.broadcastMsg(name + ": " + str);
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.equals("/end")) break;
                            if (str.startsWith("/w ")) {
                                String[] tokens = str.split("\\s");
                                String nick = tokens[1];
                                String msg = str.substring(4 + nick.length());
                                myServer.sendMsgToClient(this, nick, msg);
                            }
                        } else {
                            myServer.broadcastMsg(name + ": " + str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    myServer.unsubscribe(this);
                    myServer.broadcastMsg(name + " вышел из чата");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }
    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
