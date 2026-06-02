// better stepwise search move left down based on values
class Main {
    public static boolean searchMatrix(int[][] matrix,int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i=0;
        int j=m-1;
        while(i<n && j>=0)
        {
            if(matrix[i][j]==target)
            {
                return true;
            }else if(matrix[i][j]>target)
            {
                j--;
            }else
            {
                i++;
            }
        } return false;
    }
    public static void main(String[] args)
    {
        int[][] matrix={{1,4,7,11},{2, 5, 8, 12},
                {3, 6, 9, 16},
                {10,13,14,17}};
        int target=6;
        boolean result=searchMatrix(matrix,target);
        System.out.println(result);

    }
}
//-----------------------------------------------------------------
// Optimal Apprach


class Main {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=n*m-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target)
            {
                return true;
            }else if(matrix[row][col]<target)
            {
                low=mid+1;

            }else
            {
                high=mid-1;
            }
        }
        return false;


    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        boolean result = searchMatrix(matrix, target);
        System.out.println(result); // true
    }
}
