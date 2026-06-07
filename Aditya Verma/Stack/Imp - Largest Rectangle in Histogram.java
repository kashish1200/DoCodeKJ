//At any point of time we are checking the Nearest smaller to left and Nearest smaller to right - why?
//kyuki ek building ka area kitna aage tak jaa rha hai and kitna piche tak aa rha hai thats what we want...kab piche ya aage nhi jayega? agar usse chhota element mil gya toh
//woh chhota element find karo of left and right which will tell the total width ki kaha tak curr element spread ho sakta hai and then multiply krdo height (curr i)

//earlier I took 2 stack one for left and one for right-- then took only 1 after clearing it

// Time complexity: O(n) – Each element is pushed and popped at most once.
// Space complexity: O(n) – Arrays left, right, and stack storage.

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ansRight[] = new int[n];
        int ansLeft[] = new int[n];
        Stack<Integer> st = new Stack<>();

        //calculating nearest smaller to right
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ansRight[i] = st.peek();
            }
            else{
                ansRight[i] = n;
            }
            st.push(i);
        }

        st.clear();

        //calculating nearest smaller to left
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ansLeft[i] = st.peek();
            }
            else{
                ansLeft[i] = -1;
            }
            st.push(i);
        }

        int maximum = 0;
        for(int i =0; i<n; i++){
            int width = ansRight[i] - ansLeft[i] - 1;
            maximum = Math.max(maximum, width * heights[i]);
        }
        return maximum;
        
    }
}
