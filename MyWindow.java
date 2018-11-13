package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyWindow {
    static Scanner type = new Scanner(System.in);
    static String typed;
    static int a;
    static String get;
    static final String SERVER_ADDR = "localhost";
    static final int SERVER_PORT = 8189;
    static Socket sock;
    static Scanner in;
    static PrintWriter out;

    public static void main(String[] args) {
        System.out.println("Started");
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Thread(() -> sendMsg()).start();
            new Thread(() -> getMSg()).start();
        } catch (Exception e) {
        }
    }

    public static void sendMsg() {
        do {
            typed = type.next();
            out.println(typed);
            out.flush();
            if (typed.equals("end")) {
                a = 1;
                System.exit(0);
            }
        }
        while (a == 0);
    }

    public static void getMSg() {
        do {
            get = in.nextLine();
            System.out.println(get);
            if (get.equals("end")) {
                a = 1;
                System.exit(0);
            }
        }
        while (a == 0);
    }
}
