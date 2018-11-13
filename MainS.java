/**
 * Geekbrains. Java, lvl 2.
 * Домашнее задание к уроку 6.
 *
 * @ author Golovanov Igor
 * @ version Nov 13, 2018
 */

package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainS {
    static Scanner type = new Scanner(System.in);
    static Scanner in;
    static String typed;
    static String get;
    static int a;
    static PrintWriter out;

    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket sock = null;
        String cl;
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Thread(() -> sendMsg()).start();
        new Thread(() -> getMSg()).start();
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
