class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        //lcm = A*B / gcd
        Long ans[] = new Long[2];
        long lcm = A*B;
        long gcd =0;
        while(A>0 && B>0){
            if(A>B) A=A%B;
            else B=B%A;
        }
            if(A==0) gcd = B;
            if(B==0) gcd = A;
            
            ans[1] = gcd;
            ans[0] = lcm/gcd;
            return ans;
    }
};


class Solution {
    public static int gcd(int a, int b) {
        int gcd=1;
        for(int i=1;i<=Math.min(a,b);i++){
            if(a%i==0 && b%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
}
