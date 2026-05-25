import java.util.*;
class Main {
    public static int countPartitions(int[] nums,int mid)
    {
        int partitions=1;
        int currentSum=0;
        for(int num: nums)
        {
            if(currentSum+num<=mid)
            {
                currentSum+=num;
            }else
            {
                partitions++;
                currentSum=num;
            }
        } return partitions;
    }
    public static int splitArray(int[] nums,int k)
    {
        int low=0,high=0;
        for(int num: nums)
        {
            low=Math.max(low,num);
            high+=num;
        }
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int partitions=countPartitions(nums,mid);
            if(partitions<=k)
            {
                ans=mid;
                high=mid-1;
            }else
            {
                low=mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums={1,2,4,8,9};
        int k=2;
        System.out.println(splitArray(nums,k));
    }
}