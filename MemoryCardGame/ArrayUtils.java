package MemoryCardGame;

import java.util.SplittableRandom;

public class ArrayUtils {
    private static void swap(Card[][] arr, int x1, int y1, int x2, int y2) {
        Card temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static void shuffle(Card[][] array) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int randRowIndex = r.nextInt(array.length);
                int randColIndex = r.nextInt(array[0].length);

                swap(array, randRowIndex, randColIndex, i, j);
            }

        }

    }

    public static <T> void shuffle(T[] array) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < array.length; i++) {
            int randIndex = r.nextInt(array.length);
            T temp = array[randIndex];
            array[randIndex] = array[i];
            array[i] = temp;

        }

    }
}
