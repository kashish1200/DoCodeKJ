class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                ans.add(st.peek());
            }
            else
                ans.add(-1);
                
            st.push(arr[i]);
            
        }
        Collections.reverse(ans);
        return ans;
        
    }
}
