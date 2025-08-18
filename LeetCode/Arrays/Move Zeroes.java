class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        int n = nums.length;
        while(j<n){
            if(nums[j]!=0){
                swap(nums, i, j);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
    }
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//other approach
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int x =0;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[x] = nums[i];
                x++;
            }
            if(nums[i]==0) count++;
        }
        for(int i=x;i<n;i++){
            nums[x] = 0;
            x++;
        }
    }
}
