/**
 *  Geekbrains. Java, lvl 2.
 *  Домашнее задание к уроку 2.
 * @ author Golovanov Igor
 * @ version Oct 27, 2018
 */

package Fine;

public class Main {
    public static String addr;
    public static int sum = 0;

    public static void main(String[] args) {
        // write your code here
        String test[][] = {{"3", "2", "e", "r"}, {"a", "5", "d", "f"}, {"z", "x", "6", "v"}, {"p", "o", "i", "u"}};
        try {
            ArrEx(test);
        } catch (MyArraySizeEx e) {
            e.printStackTrace();
            System.out.println("Размер массива не соответсвует требованиям метода");
        } finally {
            System.out.println("Итоговая сумма числовых значений массива= " + sum);
        }
    }

    public static void ArrEx(String test[][]) throws MyArraySizeEx, MyArrayDataEx {
        int m = 0;
        try {
            for (int i = 0; i <= 3; i++) {
                if (test[i].length != 4) {
                    throw new MyArraySizeEx();
                }
            }
            System.out.println("Массив соответствует требованиям, значение крайней ячейки = " + test[3][3]);
        } catch (ArrayIndexOutOfBoundsException n) {
            m = 1;
        }
        if (m == 1) {
            throw new MyArraySizeEx();
        }
        int k = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                try {
                    addr = String.valueOf(i) + " " + String.valueOf(j);
                    k = Integer.parseInt(test[i][j]);
                    sum = sum + k;
                } catch (NumberFormatException n) {
                    m = 2;
                }
                try {
                    if (m == 2) {
                        throw new MyArrayDataEx();
                    }
                } catch (MyArrayDataEx e) {
                    System.out.println("Значение массива не преобразуется в число по адресу: " + addr);
                    m = 0;
                }
            }
        }
    }

}

class MyArraySizeEx extends ArrayIndexOutOfBoundsException {
}

class MyArrayDataEx extends NumberFormatException {
}