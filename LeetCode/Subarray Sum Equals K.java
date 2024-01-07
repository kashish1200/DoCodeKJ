class Solution {
    public int subarraySum(int[] nums, int k){
        int count=0;
        int prefixSum=0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            prefixSum +=  nums[i];
            if (prefixSum == k) count++;
            int remaining = prefixSum - k;
          
            if(map.containsKey(remaining)){
                count+= map.get(remaining); (copied approach)
                //count++; (my approach)
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}

// 1 1 1
// prefixSum = 1 -> 2-> 3

// rem = 3 -2 = 1
// map (1:1, 2:1, 3:1)
// count = count + 1 
// count 2
