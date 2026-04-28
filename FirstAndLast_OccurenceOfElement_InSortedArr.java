import java.util.*;

class Solution {
    private int lowerBound(int[] arr,int target) {

        int low=0, high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>=target)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        } return ans;


    }
    private int upperBound(int[] arr,int target)
    {
        int low=0,high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>target)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
    public int[] searchRange(int[] arr, int target) {
        int lb=lowerBound(arr,target);
        if(lb==arr.length||arr[lb]!=target)
        {
            return new int[]{-1,-1};
        }
        int ub=upperBound(arr,target);
        return new int[]{lb,ub-1};
    }
}

