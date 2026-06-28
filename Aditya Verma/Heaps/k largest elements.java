//Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 

//TC O(n log k)

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            minheap.add(arr[i]);
            if(minheap.size() > k){
                minheap.poll();
            }
        } //O(n log k)
        for(int i=0;i<k;i++){
            ans.add(minheap.poll()); //O(k log k)
        }
        
        Collections.reverse(ans); //O(k)
        return ans;
    }
}

//O(n log k + k log k + k) -> k ≤ n and k log k ≤ n log k
//So, the dominant term is

TC - O(n log k)
