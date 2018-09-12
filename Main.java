/**
 *  Geekbrains. Java.
 *  Домашнее задание к уроку 3
 * @ author Golovanov Igor
 * @ version Sept 12, 2018
 */



import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //ввод строки и ее реверс с использованием стека из примера в методичке
        String str = sc.next();
        String str2 = "";
        System.out.println(str);
        Pyramida stake = new Pyramida(str.length());
        System.out.println(stake.isEmpty());
        System.out.println(stake.isFull());
        //заполнение стека (символы с последнего к первому)
        for (int i = str.length() - 1; i >= 0; i--) {
            char w = str.charAt(i);
            stake.push(w);
            str2 = str2.concat(String.valueOf(stake.stack[stake.top​]));
        }
        //проверка структуры стека
        System.out.println(str2);
        stake.pop();
        System.out.println(stake.peek());
        System.out.println();
        //заполнение очереди с конца (бегущая строка в обратном порядке). Здесь макет крутится в другую сторону.
        String str3 = sc.next();
        String str4 = "";
        System.out.println(str3);
        Queue q = new Queue(str3.length());
        for (int i = 0; i <= str3.length() - 1; i++) {
            char w = str3.charAt(i);
            q.insert(w);
        }
        for (int i = 0; i <= str3.length() - 1; i++) {
            str4 = str4.concat(String.valueOf(q.queue[i]));
        }
        //проверка прохождения очереди
        System.out.println(str4);
        System.out.println();
        //проверка структуры очереди
        System.out.println("инфо об оставшихся в массиве элементах");
        for (int i = 0; i <= q.maxSize - 1; i++) {
            System.out.println(q.queue[i]);
        }
    }
}