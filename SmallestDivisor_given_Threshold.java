
class Solution {
    public static int computeSum(int[] nums,int divisor)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=(nums[i]+divisor-1)/divisor;
        } return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num: nums)
        {
            high=Math.max(high,num);
        }
        int ans=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int sum=computeSum(nums,mid);
            if(sum<=threshold)
            {
                ans=mid;
                high=mid-1;

            }else
            {
                low=mid+1;
            }
        } return ans;

    }
}