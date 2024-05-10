import java.util.Arrays;

public class Main {
    public static void lowerComplexity(int[] arr) {
        System.out.println("\nLower complexity solution:");
        System.out.println("Input array: " + Arrays.toString(arr));

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == 0) {
                System.out.println("Matching pair found: " + arr[left] + " and " + arr[right]);
                return;
            } else if (arr[left] + arr[right] < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("No matching pair found");

    }
    public static void higherComplexity(int[] arr) {
        System.out.println("\nHigher complexity solution:");
        System.out.println("Input array: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == -arr[j]) {
                    System.out.println("Matching pair found: " + arr[i] + " and " + arr[j]);
                    return;
                }
            }
        }
        System.out.println("No matching pair found");
    }

    public static int[] getSpeedTestArray() {
        int[] largeArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeArray[i] = i;
        }
        largeArray[9999] = -9999;
        return largeArray;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 2, -2, 5, -3};
        int[] test2 = {1, 1, 2, -1, 2, -1};
        int[] test3 = {1, 2, 3, -4};
        int[] test4 = {1, 1};

        lowerComplexity(test1);
        higherComplexity(test1);

        lowerComplexity(test2);
        higherComplexity(test2);

        lowerComplexity(test3);
        higherComplexity(test3);

        lowerComplexity(test4);
        higherComplexity(test4);

        long startTime = System.nanoTime();
        lowerComplexity(getSpeedTestArray());
        long endTime1 = System.nanoTime() - startTime;

        long startTime2 = System.nanoTime();
        higherComplexity(getSpeedTestArray());
        long endTime2 = System.nanoTime() - startTime2;

        System.out.println("\nSpeed test:");
        System.out.println("Time taken for lowerComplexity:  " + endTime1 + " ns");
        System.out.println("Time taken for higherComplexity: " + endTime2 + " ns");
    }
}