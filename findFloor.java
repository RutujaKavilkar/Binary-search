class Solution {
    public int findFloor(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1; // default (if no floor exists)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];   // store value
                low = mid + 1;    // move right (try bigger)
            } else {
                high = mid - 1;   // move left
            }
        }
        return ans;
    }
}