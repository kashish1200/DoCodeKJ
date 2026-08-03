class Solution {
    public int findPeakElement(int[] arr) {
       int n = arr.length;
       int s = 0;
       int e = n - 1;
       //edge case
       if(n == 1) return 0;
       while(s <= e){
           int mid = s + (e - s)/2;
           
           if(mid - 1 >= 0 && mid + 1 <= n-1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
              return mid;
           }
           else if(mid + 1 <= n-1 && arr[mid] < arr[mid+1]){
              s = mid+1;
           }
           else{
              e = mid - 1;
           }
       }
       return s;
    }
