class Solution {
    public int findTarget(int arr[], int target) {
        int n = arr.length, start = 0, end = n-1;
        while(start<=end){
            int mid = (start + end )/2;
            if(target == arr[mid]){
                return mid;
            }
            if(mid-1 >= start && target == arr[mid-1]){
                return mid-1;
            }
            if(mid+1 <= end && target == arr[mid+1]){
                return mid+1;
            }
            else if(target < arr[mid]){
                end = mid-2;
            }
            else{
                start = mid+2;
            }
        }
        return -1;
        
    }
}
