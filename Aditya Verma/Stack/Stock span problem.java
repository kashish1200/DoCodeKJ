// brute force - O(n)^2
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1; i >=0; i--){
            boolean flag = false;
            for(int j = i-1; j >=0; j--){
                if(arr[j] > arr[i]){
                    ans.add(i-j);
                    flag = true;
                    break;
                }
                
            }
            if(!flag) ans.add(i+1);
        }
        Collections.reverse(ans);
        return ans;
    }
}

//Optimized solution O(n)
//stack me storing indexes - not elements - kyuki subtract krna hai greater element ke index ko current index se...kaise karenege...purane indexes store krne k liye stack me index store kr rahe
//finding the maximum greater element in the left and then subtracting that index from the current index - i - st.peek() 
//elements ko compare krne k liye - arr[i] >= arr[st.peek()]
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(i - st.peek());
            }
            else{
                ans.add(i+ 1);
            }
            st.push(i);
        }
        return ans;
    }
}
