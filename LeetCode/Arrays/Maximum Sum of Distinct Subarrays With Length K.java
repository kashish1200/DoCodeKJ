class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0, j=0, n = nums.length; long sum=0; long result=0;
        Set<Integer> set = new HashSet<>();
        while(j<n){
            //when set contains the element, remove the elements from Set until you remove the duplicate element
            while(set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            
            //when Set contains distinct elements
            sum += nums[j];
            set.add(nums[j]);

            //when size of window is ==k
            if(j-i+1==k){
                result = Math.max(result, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;

        }
        return result;
    }
}
