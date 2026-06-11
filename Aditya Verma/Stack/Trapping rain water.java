//Using 2 loops tp calculate leftmax element arr TC O(n)^2
//At any point of time hum left max element nikal rhe and right max nikal rhe
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int minimumheight =0;
        int result=0;
        
        int[] leftarr = new int[n];
        int[] rightarr = new int[n];
        //calculating left max
        for(int i=n-1;i>=0;i--){
            int leftmax =0;
            for(int j=i; j>=0;j--){
                if(height[j]>= height[i] && height[j]> leftmax){
                    leftmax = height[j];
                    leftarr[i] = leftmax;
                }

            }
        }

        //calculating right max
        for(int i=0;i<n;i++){
            int rightmax =0;
            for(int j=i; j<n;j++){
                if(height[j]>= height[i] && height[j]> rightmax){
                    rightmax = height[j];
                    rightarr[i] = rightmax;
                }

            }
        }
        
        //to calculate kisi bhi height[i] pr kitna pani store ho sakta hai, hum leftmax and rightmax me se minimum nikalenge and height[i] se subtract
        for(int i=0;i<n;i++){
            //minimum nikalo left and right ka and khud se subtract kro
            result += Math.min(leftarr[i], rightarr[i]) - height[i];
        }

        return minimumheight;
    }
}


//Optimized approach - TC - O(n)
//Using single loop to calculate

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int minimumheight =0;
        int result=0;
        
        int[] leftarr = new int[n];
        int[] rightarr = new int[n];
        leftarr[0] = height[0];
        rightarr[n-1] = height[n-1];

        //calculating left max
        for(int i=1;i<n;i++){
            leftarr[i] = Math.max(height[i], leftarr[i-1]);
        }

        //calculating right max
        for(int i=n-2;i>=0;i--){
            rightarr[i] = Math.max(height[i], rightarr[i+1]);
        }

        for(int i=0;i<n;i++){
            //minimum nikalo left and right ka and khud se subtract kro
            result += Math.min(leftarr[i], rightarr[i]) - height[i];
        }
        return result;
    }
}
