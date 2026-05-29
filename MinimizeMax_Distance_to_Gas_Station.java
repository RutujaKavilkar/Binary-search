class Solution {

    // Helper function: how many stations are needed
    public static int numberOfGasStations(int[] arr, double dist) {
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            cnt += (int)(gap / dist);
        }

        return cnt;
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;

        double low = 0;
        double high = 0;

        // Find maximum gap → this becomes our upper bound
        for (int i = 1; i < n; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        // Precision value (important for double)
        double diff = 1e-6;

        // Binary search on answer
        while ((high - low) > diff) {
            double mid = (low + high) / 2.0;

            int cnt = numberOfGasStations(arr, mid);

            if (cnt > k) {
                // Need more stations → distance too small
                low = mid;
            } else {
                // Possible → try smaller distance
                high = mid;
            }
        }

        return high;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 10};
        int k = 1;

        double ans = minimiseMaxDistance(arr, k);
        System.out.println(ans);  // Expected ~4.5
    }
}