/**
 *  Geekbrains. Java.
 *  Домашнее задание к уроку 6. Бинарные деревья
 * @ author Golovanov Igor
 * @ version Sept 26, 2018
 */


package Fine;

//создано дерево с 6 уровнями, узлам присвоены значения L,R
public class Main {
    static int M = 0;

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(0, '0');
        Node x = tree.find(0);
        while (M <= 6) {
            M = tree.M(x) + 1;
            int z = (int) (Math.random() * 100);
            tree.insert(z, '0');
        }
        System.out.println("Прохождение по дереву методом рекурсии");
        tree.print(x);
        System.out.println("Количество уровней" + tree.M(x));
    }
}
