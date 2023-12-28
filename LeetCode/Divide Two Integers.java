Code
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        //checking is any of dividend or divisor is 0
        boolean sign = true;
        if((dividend <0  && divisor>0) || (dividend >0  && divisor<0)){
            sign=false;
        }

        //converting dividend and divisor to long
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        long result=0;

        while(m>=n){
            int shift=0;
            while(m > (n<<(shift+1))){
                shift++;
            }
            m-=n<<shift;
            result += (1<<shift);
        }

        //if dividend or divisor was 0 , we will convert result to negative
        //taking 2's compliment to convert it to negative number
        result = (sign==false) ? ~(result - 1) : result;

        //checking overflow conditions
        result = Math.min(Integer.MAX_VALUE, result);
        result = Math.max(Integer.MIN_VALUE, result);
        
        //converting result back to int, as we have to return int
        return (int)result;
    }
}
