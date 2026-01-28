class Solution {
    public int missingNumber(int[] nums) {
        int addi = 0, n = nums.length, expected =0;
        for(int i=0;i<n;i++){
            addi += nums[i];
        }
        expected = (n * (n+1))/2;
        return expected - addi;
    }
}


//other solution
public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
}
}
