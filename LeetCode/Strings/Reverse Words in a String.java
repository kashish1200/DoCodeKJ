Complexity
Time complexity: O(n)
Space complexity: O(n)
  
Code
class Solution {
    public String reverseWords(String str) {
        str = str.trim();
        String[] list = str.split(" ");
        int n = str.length();
        StringBuilder ans = new StringBuilder();

        for(int i=list.length-1; i>=0 ; i--){
        //This condition checks if the current word list[i] is not an empty string.
            if(!list[i].equals("")){
                ans.append(list[i]);
                ans.append(" ");
            }
        }
        String str2 =  ans.toString();
        return str2.trim();
    }
}
