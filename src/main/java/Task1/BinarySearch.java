package Task1;

import java.util.Arrays;

public class BinarySearch {

    // Сортировка массива, деление области поиска пополам, сравнение с центром деления.

    public static void main(String[] args) {

        int[] ints = new int[]{-15, 33, 21, -12, 15, 56, 77, 14};
        int number = 15;

        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        binarySearch(ints, number);
    }

    public static void binarySearch(int[] ints, int findNumber) {

        int first = 0;
        int last = ints.length - 1;
        int center;

        while (first <= last) {
            center = (first + last) / 2;

            if (ints[center] < findNumber) {
                first = center + 1;
            } else if (ints[center] > findNumber) {
                last = center - 1;
            } else {
                System.out.println("Found, pos - " + center);
                break;
            }
        }

        System.out.println("Not found");

    }

}
