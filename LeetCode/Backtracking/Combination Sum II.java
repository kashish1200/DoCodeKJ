class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(List<Integer> temp, int[] nums, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i> start && nums[i] == nums[i-1]){
                continue;
            }
            if(target - nums[i]>=0){
                temp.add(nums[i]);
                backtrack(temp, nums, target-nums[i], i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backtrack(temp, candidates, target, 0);
        return result;
    }
}
