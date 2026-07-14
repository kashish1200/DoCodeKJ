//TC - O(log n)
class Solution {
    int countFreq(int[] arr, int target) {
        boolean searchLeft = false;
        //calculate first occurance
        int left = binarySearch(arr, target, true);
        
        //calculate last occurance
        int right = binarySearch(arr, target, false);
        
        //if element is not there
        if(left == -1 || right == -1) return 0;
        
        //last occurance - first + 1
        int freqCount = (right - left) + 1;
        return freqCount;
        
    }
    
    //helper method to do binary search
    public int binarySearch(int[] arr, int target, boolean searchLeft){
        int start =0, end = arr.length-1;
        int result = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                if(searchLeft){
                    result = mid;
                    end = mid -1;
                }
                else{
                    result = mid;
                    start = mid +1;
                }
            }
        }
        return result;
    }
}
