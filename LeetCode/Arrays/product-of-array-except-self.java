// 1.) If count of zeroes is greater than 1 so the array will be empty
// 2.) If the count of zeroes is 0 then we need to just divide the product of array with every element
// 3.) Lastly if the count of zeroes if 1, then we need to find the index of zero and product of array without zero and then just place the product at index of zero and we are done

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int product =1;
        int countOfZero =0;
        int zeroIndex =0;
        for(int i=0;i<n;i++){
            
            if(nums[i] ==0){
                countOfZero++;
                zeroIndex = i;
            }
            else product = product * nums[i];
        }
        for(int i=0;i<n;i++){
            if(countOfZero ==0){ //if there are no zero in the array
                ans[i] = product / nums[i];
            }
            else if(countOfZero ==1){ //if count of zero is 1, if count of zero is more 1..it will always be 0
                ans[zeroIndex] = product; 
            }
            
        }
        return ans;
    }
}

//TC - O(n), SC - O(1)
