import java.util.*;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {

            int min = i;

            // Find minimum element
            for(int j = i + 1; j < n; j++) {

                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            System.out.println(
                "Pass " + (i+1) + " : " +
                Arrays.toString(arr)
            );
        }

        System.out.println(
            "\nSorted Array:"
        );

        System.out.println(
            Arrays.toString(arr)
        );
    }
}