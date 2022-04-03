package Task1;

import java.util.Arrays;

public class BubbleSorting {

// Последовательное сравнение значения соседних элементов. Если предыдущее больше следующего - числа меняются местами.
// Числа с большим значением оказываются в конце списка.

    private static int countLoop; //

    public static void main(String[] args) {

        int n = 25;

        int[] myArrInt = new int[n];
        for (int i = 0; i < n; i++) {
            myArrInt[i] = ((int) (Math.random() * 100) + 10);
        }

        System.out.println("bubbleSort Unsort " + Arrays.toString(myArrInt));
        bubbleSort(myArrInt);
        System.out.println("bubbleSort Sort " + Arrays.toString(myArrInt));

    }

    public static void bubbleSort(int[] arrUnsort) {

        int count = 0;

        for (int i = 0; i < arrUnsort.length - 1; i++){
            if (arrUnsort[i] > arrUnsort[i + 1]) {
                int memory = arrUnsort[i];
                arrUnsort[i] = arrUnsort[i + 1];
                arrUnsort[i + 1] = memory;
                count++;
            }
        }
        if (count > 0) {
            bubbleSort(arrUnsort);
        }
    }

    public static void bubbleSortNoRec(int[] array) {
        boolean unsorted = true;
        int memory;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    memory = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = memory;
                    unsorted = true;

                    countLoop++;
//                    System.out.println(countLoop + " " + Arrays.toString(array));
                }
            }
        }
    }

}
