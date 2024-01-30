Brute Force - 
TC - O(n!)

class Solution {
    String result ="";
    int count =0;
    public void backtrack(StringBuilder temp, int n, int k){
        if(temp.length()==n){
            count++;
            if(count == k){
                result = temp.toString();
            }
            return;
        }
        for(char c='1'; c<= (char)('0' + n); c++){
            if(temp.indexOf(String.valueOf(c))==-1){
                temp.append(c);
                backtrack(temp, n, k);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public String getPermutation(int n, int k) {
        StringBuilder temp = new StringBuilder();
        backtrack(temp, n, k);
        return result;
    }
}
