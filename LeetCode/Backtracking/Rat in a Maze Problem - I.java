class Solution {
   
    public static void backtrack(ArrayList<String> result,int i, int j, String temp, int[][] m, int n, boolean vis[][]) {

        if (i == n-1 && j == n-1 && m[i][j]!=0) //adding extra check, if my final dest is not blocked
        {
            result.add(temp);
            return;
        }
        if(i>=0 && i<n && j>=0 && j<n){
            if(vis[i][j]==true || m[i][j]==0)
                return;
                
                vis[i][j] = true;
                backtrack(result, i+1, j, temp + 'D', m,n, vis);
                backtrack(result, i, j-1, temp + 'L', m,n, vis);
                backtrack(result, i, j+1, temp + 'R', m,n, vis);
                backtrack(result, i-1, j, temp + 'U', m,n, vis);
                vis[i][j] = false;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        String temp = "";
        ArrayList<String> result = new ArrayList<>();
        boolean vis[][] = new boolean[n][n]; //to keep a track if a cell is visited
        backtrack(result, 0, 0, temp, m, n, vis);
        return result;
        
    }
}
