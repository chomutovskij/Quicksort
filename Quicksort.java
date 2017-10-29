import java.util.Random;

/**
 * Sorts an array of integers in ascending order.
 *
 * @author Andrej Chomutovskij
 */
public class Quicksort {
    /**
     * Sorts an array of integers in ascending order.
     *
     * @param array An array of integers.
     */
    public static void sort(int[] array) {
        shuffle(array);
        sort(array, 0, array.length - 1);
    }

    // startIndex and endIndex are both inclusive
    private static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int medianIndex = partition(array, startIndex, endIndex);

        sort(array, startIndex, medianIndex - 1);
        sort(array, medianIndex + 1, endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int median = array[startIndex];
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;

        while (true) {
            while (leftIndex < endIndex && array[leftIndex] < median) {
                leftIndex++;
            }

            while (rightIndex > startIndex && array[rightIndex] >= median) {
                rightIndex--;
            }

            if (leftIndex >= rightIndex) {
                break;
            }

            swap(array, leftIndex++, rightIndex--);
        }

        // Put the median value (from startIndex) to the correct position
        swap(array, startIndex, rightIndex);

        // Return the median index
        return rightIndex;
    }

    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 1; i < array.length; i++) {
            int j = random.nextInt(i);
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int valueAtFirstIndex = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = valueAtFirstIndex;
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 10, 4, 2, 47, 60, 40, 1447, 3};

        for (int value : array) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        sort(array);

        for (int value : array) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }
}
