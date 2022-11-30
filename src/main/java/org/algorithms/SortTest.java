package org.algorithms;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        int[] array1 = new int[1000];
        randomArray(array1);
        int[] array2 = Arrays.copyOf(array1, 1000);
        int[] array3 = Arrays.copyOf(array1, 1000);

        long start1 = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println(System.currentTimeMillis() - start1);

//        long start2 = System.currentTimeMillis();
//        sortSelection(array2);
//        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println(System.currentTimeMillis() - start3);


    }

    public static void randomArray(int[] array) {
         Random random  = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();

        }
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.println(j);
        }
    }



    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}
