class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = arr.length;
        int j=0;
        for(int i=0;i<n;i++){
            minheap.add(arr[i]);
            if(minheap.size() > k){
                arr[j] = minheap.poll();
                j++;
            }
        }
        while(!minheap.isEmpty()){
            arr[j] = minheap.poll();
            j++;
        }
    }
}
//tc - o(n log k)
