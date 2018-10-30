/**
 *  Geekbrains. Java, lvl 2.
 *  Домашнее задание к уроку 3.
 * @ author Golovanov Igor
 * @ version Oct 29, 2018
 */

package Fine;

import java.util.ArrayList;


public class Main {
    static int counter = 1;

    public static void main(String[] args) {
        // Задание 1. Создание коллекции уникальных элементов
        ArrayList<String> a1 = new ArrayList<String>();
        String a2[] = {"a", "b", "c", "a", "c", "k", "a", "a", "k", "f"};
        for (int n = 0; n <= a2.length - 1; n++) {
            a1.add(a2[n]);
        }
        System.out.println("Изначальный массив " + a1);
        for (int n = 0; n <= a1.size() - 1; n++) {
            String a = a1.get(n);
            for (int m = 0; m <= a1.size() - 1; m++) {
                String b = a1.get(m);
                if (b == a) {
                    if (m != n) {
                        a1.remove(m);
                        counter++;
                        m = 0;
                    }
                }
            }
            System.out.println(a + " встречается раз " + counter);
            counter = 1;
        }
        System.out.println("Итоговая коллекция без дублей " + a1);

        // Задание 2. Телефонный справочник (пришлось делать домашку до вебинара, по методичке
        //понятно, что решение хромое  :))
        String temp;
        ArrayList<ArrayList<String>> x2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> x21 = new ArrayList<>();
        ArrayList<String> x22 = new ArrayList<>();
        ArrayList<String> x23 = new ArrayList<>();
        ArrayList<String> x24 = new ArrayList<>();
        x21.add("A");
        temp = x21.get(0);
        x24.add(temp);
        x21.add("123");
        x21.add("321");
        x22.add("B");
        temp = x22.get(0);
        x24.add(temp);
        x22.add("789");
        x22.add("987");
        x23.add("C");
        temp = x23.get(0);
        x24.add(temp);
        x23.add("456");
        x23.add("645");
        x2.add(x21);
        x2.add(x22);
        x2.add(x23);
        for (int n = 0; n <= x24.size() - 1; n++) {
            String temp2 = x24.get(n);
            if (temp2 == "B") {
                System.out.println("Телефонные номера абонента" + x2.get(n));
            }
        }
    }
}

