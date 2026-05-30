class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        
        
        //---------Naive Approach---------
        /*ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            boolean flag = false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    flag = true;
                    al.add(arr[j]);
                    break;
                }
            }
            if(!flag){
                al.add(-1);
            }
        }
        
        return al;


//optimized approach - o(n)
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack <Integer> st = new Stack <>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[i]>= st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(st.peek());
            }
            else{
                ans.add(-1);
            }
            st.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
        
    }
}
