class Solution {
    public static long sumBetweenTwoKth(long arr[], long n, long k1, long k2) {
        PriorityQueue<Long> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        long count = k2-k1-1;
        long ans =0;
        
        for(int i=0;i<n;i++){
            maxheap.add(arr[i]);
            if(maxheap.size() >= k2){
                maxheap.poll();
            }
        }
        while(count!=0){
            ans+=maxheap.poll();
            count--;
            
        }
        return ans;
    }
}
