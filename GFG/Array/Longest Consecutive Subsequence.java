
//solution 1
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int count =0, max_length=0;
    
        for(int i=0;i<arr.length-1;i++){
                if(arr[i+1] - arr[i] == 1){
                    count++;
                }
                if(arr[i+1] - arr[i]>1){
                    count =0;
                }
                    
                max_length = Math.max(count+1, max_length);
        }
        return max_length;
    }
}

//solution 2
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        int max_length=0;
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<n;i++){
          // only start counting if num is the beginning of a sequence
          //In the optimal HashSet solution, you only try to build a sequence if the current number is the start of a sequence → i.e., arr[i] - 1 is not in the set.
          //Otherwise, you’ll keep re-counting the same sequence multiple times.
            if(!set.contains(arr[i] - 1)){
                int curr_num = arr[i];
                int count =1;
                while(set.contains(curr_num+1)){
                    curr_num++;
                    count++;
                }
                max_length = Math.max(count, max_length);
            }
            
        }
        return max_length;
        
    }
}
