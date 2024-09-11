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
