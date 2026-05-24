
class Main {
    public static boolean canMake(int[] bloomDay,int mid,int m,int k)
    {
        int count=0;
        int bouquets=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid){
                count++;
                if(count==k)
                {
                    bouquets++;
                    count=0;

                }

            }else{
                count=0;
            }
        }
        return bouquets>=m;
    }
    public static int minDays(int[] bloomDay,int m,int k)
    {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);

        }
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canMake(bloomDay,mid,m,k))
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
    public static void main(String[] args) {
        int[] bloomDay={1,10,3,10,2};
        int m=3;
        int k=1;
        int result=minDays(bloomDay,m,k);
        System.out.println(result);

    }
}