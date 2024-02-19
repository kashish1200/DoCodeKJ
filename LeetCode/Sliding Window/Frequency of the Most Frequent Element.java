class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int head =0, tail =0, ans=1;
        long sum =0;
        for(head=0; head<n; head++){
            sum += nums[head];
            while(((long)(head-tail+1) * nums[head]) - sum > k){
                sum -= nums[tail];
                tail++;
            }  
            ans = Math.max(ans, head-tail+1); 
        }
        return ans;
    } 	
}
