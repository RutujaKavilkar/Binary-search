
class Main {
    public static int search(int[] arr,int low,int high)
    {
        int mini=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<mini)
                {
                    mini=arr[low];
                    index=low;
                }
                low=mid+1;
            }
            else{
                if(arr[mid]<mini)
                {
                    mini=arr[mid];
                    index=mid;
                }high=mid-1;

            }} return index;
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2,3};
        int n=arr.length;
        int low=0;
        int high=n-1;
        int rotated=search(arr,low,high);
        System.out.println(rotated);

    }
}