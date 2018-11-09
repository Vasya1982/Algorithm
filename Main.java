/**
 * Geekbrains. Java, lvl 2.
 * Домашнее задание к уроку 5.
 *
 * @ author Golovanov Igor
 * @ version Nov 09, 2018
 */
package Fine;

public class Main {
    static final int l = 20;
    static float arr[] = new float[l];
    static float arr1[] = new float[l / 2];
    static float arr2[] = new float[l / 2];

    public static void main(String[] args) {
        M1();
        M2();
        new Thread(() -> Count(arr1)).start();
        new Thread(() -> Count(arr2)).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        M3();
    }

    public static void M1() {
        System.out.println("Метод 1");
        long a = 0;
        long b = 0;
        for (int n = 0; n <= arr.length - 1; n++) {
            arr[n] = 1;
            a = a + System.currentTimeMillis();
        }
        System.out.println("Время заполнения массива " + a);
        for (int n = 0; n <= arr.length - 1; n++) {
            arr[n] = (float) (arr[n] * Math.sin(0.2f + n / 5) *
                    Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
            b = b + System.currentTimeMillis();
        }
        System.out.println("Время замены элементов массива " + b);
        //System.out.println("Значение величины элемента массива " + arr[5]);
        System.out.println();
    }

    public static void M2() {
        System.out.println("Метод 2");
        long a = 0;
        for (int n = 0; n <= arr.length - 1; n++) {
            arr[n] = 1;
            a = a + System.currentTimeMillis();
        }
        System.out.println("Время заполнения массива " + a);
        System.arraycopy(arr, 0, arr1, 0, l / 2);
        System.arraycopy(arr, 10, arr2, 0, l / 2);
    }

    public static synchronized void Count(float arr[]) {
        long b = 0;
        for (int n = 0; n <= arr.length - 1; n++) {
            arr[n] = (float) ((arr[n] * 1) * Math.sin(0.2f + n / 5) *
                    Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
            b = b + System.currentTimeMillis();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Время замены элементов массива " + b);
    }

    public static void M3() {
        long c = 0;
        System.arraycopy(arr1, 0, arr, 0, l / 2);
        System.arraycopy(arr2, 0, arr, 10, l / 2);
        c = c + System.currentTimeMillis();
        System.out.println("Время склейки массива " + c);
        //for (int n = 0; n <= arr.length - 1; n++) {
        //    System.out.println("Значение величины элемента массива " + n + " " + arr[n]);}
    }
}