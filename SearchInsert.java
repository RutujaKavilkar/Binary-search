class Solution {
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;        // possible insert position
                high = mid - 1;   // go left
            } else {
                low = mid + 1;    // go right
            }
        }
        return ans;
    }
}