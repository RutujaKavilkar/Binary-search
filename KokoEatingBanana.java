class Main {  // Brute force approach
    public static int findHours(int[] piles,int speed)
    {
        int totalHours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalHours+=Math.ceil((double)piles[i]/speed);

        } return totalHours;
    }
    public static int minEatSpeed(int[] piles,int H)
    {
        int max=0;
        for(int i=0;i<piles.length;i++)
        {
            max=Math.max(max,piles[i]);
        }
        for(int speed=1;speed<=max;speed++)
        {
            int hours=findHours(piles,speed);
            if(hours<=H)
            {
                return speed;
            }
        } return -1;
    }
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int H=8;
        System.out.println(minEatSpeed(piles,H));
    }
}
//-------------------------------------------------------------------------------------------------

class Main {      //Optimal Approach
    public static int findHours(int[] piles,int speed)
    {
        int totalHours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalHours+=Math.ceil((double)piles[i]/speed);
        }return totalHours;
    }
    public static int minEatSpeed(int[] piles,int H)
    {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++)
        {
            high=Math.max(high,piles[i]);
        }
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int hours=findHours(piles,mid);
            if(hours<=H)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
    }
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int H=8;
        System.out.println(minEatSpeed(piles,H));
    }
}