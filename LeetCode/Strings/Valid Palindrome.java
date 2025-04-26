class Solution {
     public boolean isPalindrome(String s) {

    //Approach 1
        if(s == " ")
        return true;
        s = s.toLowerCase();

        char [] c = s.toCharArray();
        String curr="";

         for(int i=0;i<c.length;i++){
            if((c[i]>='a' && c[i]<='z') || (c[i]>='0' && c[i]<='9')){
                curr+=c[i];
             }
         }
         StringBuilder sb = new StringBuilder(curr);
         sb.reverse();
         String reversedString = sb.toString();
         if(reversedString.equals(curr)){
             return true;
         }
         return false;
    }

//Approach 2
//  String alpha = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();   //With regex to remove all non alphanumeric char



      //Approach 3  
     //By using isLetterOrDigit method to get all the alphanumeric values
     s = s.toLowerCase();
      StringBuilder alpha = new StringBuilder();
      for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                alpha.append(c);
            }
        }
        

    int left = 0;
    int right = alpha.length() - 1;

    while (left <= right) {
        if (alpha.charAt(left) != alpha.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
}



class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            else c++;
        }
        
 
        if(isPalindromeInternal(sb.toString())){
            return true;
        }
        else return false;
    }


    public boolean isPalindromeInternal(String s){
        int low = 0, hi = s.length()-1;
        while(low<hi){
            if(s.charAt(low)== s.charAt(hi)){
                low++; hi--;
            }
            else return false;
        }
        return true;
    }
}
----
//Recursion
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            else c++;
        }
        int low= 0, hi = sb.length()-1;
 
        if(isPalindromeInternal(sb.toString(), low, hi)){
            return true;
        }
        else return false;
    }


    public boolean isPalindromeInternal(String s, int low, int hi){
        if(low>=hi) return true;
        if(s.charAt(low)!= s.charAt(hi)){
            return false;
        }
        return isPalindromeInternal(s, low+1, hi-1);

        
    }
}
