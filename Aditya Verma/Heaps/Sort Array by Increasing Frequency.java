Intuition:
Count the frequency of each element, then use a min-heap to retrieve elements in increasing frequency order (and decreasing value when frequencies are equal).

Complexity
Time complexity: O(n log n)
Space complexity: O(n)
  
// Code
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Min Heap stores {frequency, element}
        // Sorting Rules:
        // 1. Smaller frequency comes first.
        // 2. If frequencies are equal, larger element comes first.
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            // Same frequency -> larger element first
            (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        );
        int[] ans = new int[nums.length];
        int j=0;

        //Calculating freq of each element
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // Insert every unique number along with its frequency
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minheap.add(new int[]{entry.getValue(), entry.getKey()});
        }

        while(!minheap.isEmpty()){
            int[] pair = minheap.poll();
            int freq = pair[0];
            int element = pair[1];

            // Insert the element 'freq' number of times
            for(int i=0;i<freq;i++){
                ans[j++] = element;
            }
        }
        return ans;
    }
}
