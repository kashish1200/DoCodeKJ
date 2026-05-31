class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            boolean flag = false;
            for(int j=i-1;j>=0;j--){
                if(arr[j]< arr[i]){
                    ans.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag) ans.add(-1);
        }
        Collections.reverse(ans);
        return ans;
    }
}

class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] <= st.peek()){
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
        return ans;
    }
}
