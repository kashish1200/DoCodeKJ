class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0, maxcount =0, n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                if(count > maxcount){
                    maxcount = count;
                }
            }
            else{
                count =0;
            }
        }
        return maxcount;
    }
}
