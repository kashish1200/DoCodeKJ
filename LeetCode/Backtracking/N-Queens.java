Code
class Solution {
    List<List<String>> result = new ArrayList<>();

    public void solve(char board[][], int n, int row){
        if(row == n){
            result.add(copyBoard(board));
        }
        for(int col=0;col<n;col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solve(board, n, row + 1);
                board[row][col] = '.';
            }
        }
    } 

    //function to check if a cell is safe for a queen
    private boolean isSafe(char board[][], int row, int col){
        int r = row-1;

        //vertical
        for(int i=0;i<board.length;i++){
            if(board[i][col] == 'Q')
                return false;
        }
        //horizontal
        for(int j=0;j<board.length;j++){
            if(board[row][j] == 'Q')
                return false;
        }
        //upper left
        for(int c= col-1; c>=0 && r>=0; c--, r--){
            if(board[r][c]=='Q')
                return false;
        }

        //upper right
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }

    //function to convert board to a string and add it to a list
    private List<String> copyBoard(char[][] board){
        List<String> copy = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            copy.add(new String(board[i]));
        }
        return copy;
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        //creating a board with .
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<String> temp = new ArrayList<>();
        solve(board, n, 0);
        return result;
    }
}
