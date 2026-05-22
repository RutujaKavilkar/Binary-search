class Main {
    public static int SingleEle(int[] arr,int low,int high)
    {
        int n=arr.length;
        if(n==0)
        {
            return arr[0];
        }
        if(arr[0]!=arr[1])
            return arr[0];
        if(arr[n-1]!=arr[n-2])
            return arr[n-1];
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]!=arr[mid-1]&&arr[mid+1]!=arr[mid])
            {
                return arr[mid];
            }
            else if(mid%2==1 && arr[mid-1]==arr[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        } return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=SingleEle(arr,low,high);
        System.out.println(ans);

    }
}