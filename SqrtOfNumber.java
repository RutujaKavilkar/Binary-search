
class Main {
    public static int SingleEle(int low,int high,int N)
    {
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid*mid==N){
                return mid;
            }else if(mid*mid<N)
            {
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }

        } return ans;
    }
    public static void main(String[] args) {
        int N=36;
        int low=1,high=N;
        int ans=SingleEle(low,high,N);
        System.out.println(ans);

    }
}