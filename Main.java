/**
 *  Geekbrains. Java.
 *  Домашнее задание к уроку 5. Рекурсия
 * @ author Golovanov Igor
 * @ version Sept 21, 2018
 */
package Fine;

public class Main {
    public static void main(String[] args) {
        //   добавим двухмерный массив вещей для похода. Перввое измерение - это их ценность, а второе - вес
        int[][] x = {{3, 7, 9, 2, 4}, {3, 5, 7, 8, 1}};
        //выведем массив на печать
        System.out.println("Было");
        for (int clmn = 0; clmn <= 1; clmn++) {
            for (int row = 0; row <= x[0].length - 1; row++) {
                System.out.print(x[clmn][row]);
            }
            System.out.println();
        }
        //отсортируем массив вещей по их ценности, при этом вес вещей связан с ценностью, т.е. при сортировке первого
        // измерения, значения во втором меняются вслед за первым. Для сортировки используем рекурсию
        int low = 0;
        int high = x[0].length - 1;
        quickSort quickSort = new quickSort();
        quickSort.quickSort1(x, low, high);
        //выведем отсортированный массив на печать
        System.out.println("Стало");
        for (int clmn = 0; clmn <= 1; clmn++) {
            for (int row = 0; row <= x[0].length-1; row++) {
                System.out.print(x[clmn][row]);
            }
            System.out.println();
        }
        // Заполним массив вещами до того момента, как их общий вес не превысит грузоподъемность рюкзака
        //при этом вещи складываются в рюкзак по мере убывания их ценности
        // есть проверка на предмет исчерпания списка вещей (чтобы не выйти за границы массива)
        int bag = 0;
        int n = x[1].length-1;
        int price = 0;
        while (bag <= 15 && n >= 0) {
            bag = bag + x[1][n];
            price = price + x[0][n];
            n--;
        }
        if (bag > 15) {
            n++;
            bag = bag - x[1][n];
            price=price-x[0][1];
        }
        n=(x[1].length-1)-n;
        System.out.println("Вес рюкзака = " + bag);
        System.out.println("Количество вещей = " + n);
        System.out.println("Ценность вещей =" + price);
    }
}
