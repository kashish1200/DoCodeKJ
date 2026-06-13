//Time Complexity: O(rows * cols) for scanning each row and applying histogram logic.
Space Complexity: O(cols) for storing heights and stacks.
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int resultArr[] = new int[m];
      

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              // Update resultArr: increment if '1', reset if '0'
                if(matrix[i][j] != '0'){
                    resultArr[j]+= 1;
                }
                else {
                    resultArr[j] = 0;
                }
            }
            //calling MAH
            maxArea = Math.max(maximumAreaHistogram(resultArr), maxArea);
        }
        return maxArea;
        
    }
    public int maximumAreaHistogram(int heights[]){
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
