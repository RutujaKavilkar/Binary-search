public class FindPeakElement2D {

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {

            int midCol = (low + high) / 2;

            // Step 1: find max element row in this column
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Step 2: check left and right
            int left = midCol - 1 >= 0 ? mat[maxRow][midCol - 1] : -1;
            int right = midCol + 1 < m ? mat[maxRow][midCol + 1] : -1;

            // Step 3: check peak
            if (mat[maxRow][midCol] > left && mat[maxRow][midCol] > right) {
                return new int[]{maxRow, midCol};
            }
            else if (mat[maxRow][midCol] < left) {
                high = midCol - 1; // move left
            }
            else {
                low = midCol + 1;  // move right
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 15},
                {21, 30, 14},
                {7,  16, 32}
        };

        int[] result = findPeakGrid(matrix);

        System.out.println("Peak at Row: " + result[0] + ", Col: " + result[1]);
    }
}gi