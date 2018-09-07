/**
 *  Geekbrains. Java. 
 *  Домашнее задание к уроку 2
 * @ author Golovanov Igor
 * @ version Sept 07, 2018
 */

//все сделал в одном файле (классе) для скорости проверки


import java.util.Arrays;

public class Massive1 {

    public static void main(String[] args) {

        //создание массива
        int mass[];
        mass = new int[10];

        //заполнение и сортировка массива пузырьковая
        for (int i = 0; i <= mass.length - 1; i++) {
            mass[i] = (int) Math.round(Math.random() * 10);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 0; i <= mass.length - 1; i++) {
            for (int j = 0; j <= mass.length - 2; j++) {
                if (mass[j] >= mass[j + 1]) {
                    int k;
                    k = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = k;
                }
            }
        }
        System.out.println(Arrays.toString(mass));

        //заполнение и сортировка методом выбора
        for (int i = 0; i <= mass.length - 1; i++) {
            mass[i] = (int) Math.round(Math.random() * 10);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 0; i <= mass.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j <= mass.length - 1; j++) {
                if (mass[j] < mass[min]) {
                    min = j;
                }
            }
            int k = mass[i];
            mass[i] = mass[min];
            mass[min] = k;
        }
        System.out.println(Arrays.toString(mass));

        //заполнение и сортировка методом вставки
        for (int i = 0; i <= mass.length - 1; i++) {
            mass[i] = (int) Math.round(Math.random() * 10);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 1; i <= mass.length - 1; i++) {
            int k = mass[i];
            int j = i;
            while (j > 0 && mass[j - 1] >= k) {
                mass[j] = mass[j - 1];
                --j;
            }
            mass[j] = k;
        }
        System.out.println(Arrays.toString(mass));

        // добавление элементов. В java массив не динамический, поэтому можно только создать новый массив
        int m = mass.length + 1;
        int mass3[];
        mass3 = new int[m];
        for (int i = 0; i <= mass.length - 1; i++) {
            mass3[i] = mass[i];
        }
        System.out.println(Arrays.toString(mass3));

        //удаление элемента со смещением
        for (int i = 3; i <= mass3.length - 2; i++) {
            mass3[i] = mass3[i + 1];
        }
        mass3[mass3.length - 1] = 0;
        System.out.println(Arrays.toString(mass3));

        //поиск элемента
        boolean check = false;
        for (int i = 0; i <= mass3.length - 1; i++) {
            if (mass3[i] == 3) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        System.out.println(check);

    }
}