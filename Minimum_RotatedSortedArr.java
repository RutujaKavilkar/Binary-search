class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mini=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[low]<=arr[mid])
            {
                mini=Math.min(mini,arr[low]);
                low=mid+1;
            }else if(arr[mid]<=arr[high]){
                mini=Math.min(mini,arr[mid]);
                high=mid-1;
            }
        }return mini;
    }

}