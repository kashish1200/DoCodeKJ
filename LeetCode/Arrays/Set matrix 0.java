class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    setRow0(i,n,matrix);
                    setCol0(j,m,matrix);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }

            }
        }
    }
    public void setRow0(int i, int n, int[][] matrix){
        for(int j=0;j<n;j++){
            if(matrix[i][j]!=0) matrix[i][j]=-1;
        }
    }
    public void setCol0(int j, int m, int[][] matrix){
        for(int i=0;i<m;i++){
            if(matrix[i][j]!=0) matrix[i][j]=-1;
        }
    }
}

//approach 2, optimized with O(2m*n)TC
class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Flags to check if the first row or first column need to be zeroed out
        boolean isrow0 = false, iscol0 = false;

        // Step 1: Check if the first row contains any zero
        // We keep this separate because we’re going to use the first row as a marker,
        // so we need to remember if it originally had zeroes.
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isrow0 = true;
            }
        }

        // Step 2: Check if the first column contains any zero
        // Similarly, we check this because the first column will also be used as a marker.
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                iscol0 = true;
            }
        }

        // Step 3: Use the first row and first column as markers
        // If any element (i, j) is zero, mark its marker row and column by setting to zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark the row
                    matrix[0][j] = 0;  // mark the column
                }
            }
        }

        // Step 4: Zero out elements based on the markers
        // If the row marker or column marker is zero, set the element to zero.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if ((matrix[i][0] == 0) || (matrix[0][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle the first row separately (if it originally had a zero)
        if (isrow0) { 
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Handle the first column separately (if it originally had a zero)
        if (iscol0) { 
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
