class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length, s=0, e= n-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(mid-1>=0 && mid+1<=n-1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid+1<=n-1 && arr[mid]< arr[mid+1]){
                s = mid+1;
            }
            else{
                e = mid -1;
            }
        }
        return -1;
        
    }
}
