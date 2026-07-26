class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n= letters.length;
        int start =0, end = n-1, ans =0;
        while(start<=end){
            int mid = (start+end)/2;
            if(letters[mid] > target){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return letters[ans];    
    }
}
