class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap based on distance from the origin.
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Result array to store the k closest points
        int[][] ans = new int[k][2];
        int i = 0;

        // Traverse all the points
        for(int i=0; i<points.length; i++){
            int distance = (points[i][0]) * (points[i][0])  + (points[i][1]) * (points[i][1]);
            // Store {distance, x, y} in the heap
            maxheap.add(new int[]{distance, points[i][0], points[i][1]});
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }
     
        // Extract points from the heap, remaining elements from the heap
        while (!maxheap.isEmpty()) {
            int[] curr = maxheap.poll();
            ans[i++] = new int[]{curr[1], curr[2]};
        }

        return ans;
    }
}
