class Solution {
    public int lowerBound(int[] arr, int t) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n; // default

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= t) {
                ans = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1; // move right
            }
        }
        return ans;
    }
}