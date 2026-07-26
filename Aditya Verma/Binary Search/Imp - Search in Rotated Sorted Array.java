Approach 1 - Find the minimum element and then binary search on the left and on the right
-----
class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int start =0, end=n-1;
        int minIndex =0;
        boolean isLeft=false;
        
        while(start<=end){
            int mid = (start+end)/2;
            int prev = (mid -1 + n)%n;
            int next = (mid+1)%n;
            //finding the minimum  index
            if(arr[mid]< arr[next] && arr[mid]< arr[prev]){
                minIndex = mid;
                break;
            }
            // Minimum lies in right half
            else if (arr[mid] > arr[end]) {
                start = mid + 1;
            }
            // Minimum lies in left half
            else {
                end = mid - 1;
            }
        }
       //if array is sorted, search in the entire array
        if (minIndex == 0) {
            return binarySearch(arr, target, 0, n - 1);
        }
        //checking if target lies in left
        if (target >= arr[0] && target <= arr[minIndex - 1]) {
            isLeft = true;
        }
        //if the element lies in [start - minIndex] range
        if(isLeft){
            int left = binarySearch(arr, target, 0, minIndex-1); 
            return left;
        }
        //if the element lies in [minIndex - end] range
        else{
            int right = binarySearch(arr, target, minIndex, n-1); 
            return right;
        }    
    }
    //helper method to do binary search
        public int binarySearch(int[] arr, int target, int start, int end){
          
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
                        return mid;
                    }
            }
            return -1;
        }
}
------
Approach 2 - Finding mid, checking if left is sorted - check if target lies in the range otherwise check in right, simple approach
-----

class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int start =0, end=n-1;
        
        while(start<=end){
            int mid = (start + end)/2;
            if(target == arr[mid]){
                return mid;
            }
            //if left part is sorted, and target lies in the range 

            //Left half is sorted
            else if(arr[start] <= arr[mid]){
                //Target lies in left sorted half
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid-1;
                }
                // Target lies in right half
                else start = mid +1;
            }
          
            // Right half is sorted
            else{
               // Target lies in right sorted half
               if(arr[mid] <= target && target <= arr[end]){
                    start = mid+1;
                }
                // Target lies in left half
                else end = mid-1;
            }
            
        }
        return -1;
    }
}
