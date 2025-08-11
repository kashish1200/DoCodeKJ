class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                ans.add(arr[i+1]);
            }
        }
        return ans;
    }
}
