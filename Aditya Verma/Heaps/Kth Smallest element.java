class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        int n = arr.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            maxheap.add(arr[i]);
            if(maxheap.size() > k){
                maxheap.poll();
            }
            
        }
        return maxheap.peek();
        
    }
}
//TC O(n log k)
