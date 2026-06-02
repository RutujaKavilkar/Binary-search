public class Search2DMatrixII {

    public static int[] searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {

            if (matrix[row][col] == target) {
                return new int[]{row, col}; // return position
            }
            else if (matrix[row][col] > target) {
                col--;  // move left
            }
            else {
                row++;  // move down
            }
        }

        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        int target = 6;

        int[] result = searchMatrix(matrix, target);

        System.out.println("Row: " + result[0] + ", Col: " + result[1]);
    }
}

// Optimal

public class Search2DMatrixIIBinary {

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int col = binarySearch(matrix[i], target);

            if (col != -1) {
                return new int[]{i, col};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        int target = 16;

        int[] result = searchMatrix(matrix, target);

        System.out.println("Row: " + result[0] + ", Col: " + result[1]);
    }
}