
package Fine;

public class quickSort {
    public static void quickSort1(int[][] array, int low, int high) {
        if (array[0].length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[0][middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[0][i] < opora) {
                i++;
            }
            while (array[0][j] > opora) {
                j--;
            }
            if (i <= j) {
                //меняем местами элементы обоих измерений массива
                int temp = array[0][i];
                int temp2 = array[1][i];
                array[0][i] = array[0][j];
                array[1][i] = array[1][j];
                array[0][j] = temp;
                array[1][j] = temp2;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort1(array, low, j);
        if (high > i)
            quickSort1(array, i, high);
    }
}
