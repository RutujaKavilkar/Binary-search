import java.util.*;

class Main {

    // lower_bound: first index where value >= target (1)
    public static int lowerBound(int[] arr, int m, int target) {
        int low = 0, high = m - 1;
        int ans = m;  // default if no 1 found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;  // go left
            } else {
                low = mid + 1;   // go right
            }
        }
        return ans;
    }

    public static int rowWithMax1s(int arr[][], int n, int m) {
        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int firstOneIndex = lowerBound(arr[i], m, 1);
            int countOnes = m - firstOneIndex;

            if (countOnes > maxCount) {
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };

        int n = arr.length;
        int m = arr[0].length;

        int result = rowWithMax1s(arr, n, m);
        System.out.println("Row with maximum 1s: " + result);
    }
}