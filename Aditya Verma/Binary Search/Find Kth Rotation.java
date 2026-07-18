//Brute force, finding the drop
class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int count =0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                count = i+1;
            }
        }
        return count;
    }
}

//With Binary Search - O(log n)
class Solution {
    public int findKRotation(int arr[]) {
        // find smallest element
        
        int start =0,end = arr.length-1;
        int n = arr.length;
   
        while(start <= end){
            int mid = (start + end)/2;
            //avoiding the out of bounds
            int prev = (mid-1+n) % n;
            int next = (mid +1) %n;
            
            //checking if entire array is sorted
            if(arr[start] <= arr[end]) return start;
            
            //finding mid which is lesser then its previous and next element
            if(arr[mid] < arr[next] && arr[mid] < arr[prev]){
                return mid;
            }
            //if the right part is sorted, we will search in the left portion
            else if(arr[end] >= arr[mid]){
                end = mid -1;
            }
            //if the left part is sorted, we will search in the right portion
            else{
                start = mid+1;
            }
           
        }
        return -1;
        
    }
}
