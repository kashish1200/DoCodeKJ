class Solution{
    static int evenlyDivides(int N){
        int result =0;
        String temp = Integer.toString(N);
        int newarr[] = new int[temp.length()];
        for(int i=0;i<temp.length();i++){
            newarr[i] = temp.charAt(i) - '0';
        }
        for(int i=0;i<newarr.length;i++){
            if(newarr[i]==0){
                continue;
            }
            if(N%newarr[i]==0){
                result++;
            }
        }
        return result;
    }
}



//Approach 2
class Solution {
    static int evenlyDivides(int n) {
        int count =0;
        String num = String.valueOf(n);
        char[] c = num.toCharArray();
        for(char ch: c){
            int digit = ch - '0';
            if(digit!=0 && n%digit==0){
                count++;
            }
        }
        return count;
    }
}
