//Stair case approach - works on GFG
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n= matrix[0].length;
        int i =0;
        int j = n-1;
        while(i>=0 && i<=m-1 && j>=0 && j<=n-1){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
//row and columns are sorted, binary search on each row and each col - need to understand better

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m - 1;
        int row = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= matrix[mid][0]) {
                row = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        start = 0;
        end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
