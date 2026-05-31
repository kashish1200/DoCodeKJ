//Brute force approach - O(n)^2
//Interview tip - For every element, I can look to its left and move backwards until I find a greater element. If I find one, that's the answer; otherwise it's -1. This would take O(n²) time in the worst case.

class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=n-1;i>=0;i--){
            boolean flag = false;
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[i]){
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

//Tip - The problem is that I'm repeatedly scanning the same elements. For example, when processing multiple elements, I may keep checking the same values on the left again and again.
// For each element, I only care about previous elements that are larger than it. Smaller elements are not useful once a larger element appears after them

// Imp - This suggests maintaining a stack of candidate Previous Greater Elements. While processing from left to right, I'll remove elements from the stack that are smaller than
//     or equal to the current element because they can never serve as a Previous Greater Element anymore.

//Optimized approach - Stack - O(n)

class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] >= st.peek()){
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
