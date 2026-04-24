class Solution {
    public int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n; // default (if no element > x)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;       // possible answer
                high = mid - 1;  // move left
            } else {
                low = mid + 1;   // move right
            }
        }
        return ans;
    }
}