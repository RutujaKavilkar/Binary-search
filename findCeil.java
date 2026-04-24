class Solution {
    public int findCeil(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1; // default (if no ceil exists)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = arr[mid];   // store value (not index)
                high = mid - 1;   // go left
            } else {
                low = mid + 1;    // go right
            }
        }
        return ans;
    }
}