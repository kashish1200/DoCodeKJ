class Solution {
    static boolean isPrime(int n) {
        for(int i=1;i<=n;i++){
            if(n%i==0 && i!=1 && i!=n){
                return false;
            }
            
        }
        return true;
        
    }
}

---

class Solution {
    static boolean isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
            
        }
        return true;
        
    }
}
