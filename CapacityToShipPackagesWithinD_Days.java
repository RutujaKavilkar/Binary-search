
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w: weights)
        {
            low=Math.max(low,w);
            high+=w;
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canShip(weights,days,mid))
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean canShip(int[] weights,int days,int capacity)
    {
        int requiredDays=1;
        int currentLoad=0;
        for(int w: weights)
        {
            if(currentLoad+w> capacity)
            {
                requiredDays++;
                currentLoad=0;
            }
            currentLoad+=w;

        }return requiredDays <= days;
    }
}