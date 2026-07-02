class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //PQ storing pairs of difference of elements with x, element
        //if keys are same, compare on values
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> {
            if(a[0]== b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });

        List<Integer> ans = new ArrayList<>();

        //storing key, value pairs...keys difference, value arr[i]
        for(int i=0; i<arr.length; i++){
            int diff = Math.abs(arr[i] - x);
            maxheap.add(new int[]{diff, arr[i]});
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }
        while(!maxheap.isEmpty()){
            int pair[] = maxheap.poll();
            ans.add(pair[1]);
        }
        Collections.sort(ans);
        return ans;

        
    }
}
