        //Time complexity: O(n + m)
        //Space complexity: O(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map= new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        int n2 = nums2.length;
        int n1 = nums1.length;
        int ans[] = new int[n1];
        
        //HashMap me pehle se answer store krke rakhlo, ki what is the next greater, then hashmap me search krke ans me dal do
        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                map.put(nums2[i], st.peek());
            }
            else{
                map.put(nums2[i], -1);
            }
            st.push(nums2[i]);

        }
        for(int i=0;i<n1;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
        
    }
}
