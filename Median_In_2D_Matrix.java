import java.util.*;

public class MedianRowWiseSortedMatrix {

    // Count of elements <= target in a row
    public static int countSmallerEqual(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // number of elements <= target
    }

    public static int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Step 1: find min and max
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int desired = (n * m) / 2;

        // Step 2: Binary Search on answer
        while (low <= high) {
            int mid = (low + high) / 2;

            int count = 0;

            // count elements <= mid
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(matrix[i], mid);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        int median = findMedian(matrix);

        System.out.println("Median is: " + median);
    }
}