class Solution {
    static int[] passedBy(int a, int b) {
        
        //pass by value
        a = a+1;
        //pass by ref
        int bob[] = new int[1]; //1 size of array
        bob[0] = b; //0th position pr b value dal rhi
        
        
        int bnew = passbyref(bob);
        return new int[]{a, bnew};
    }
    public static int passbyref(int[] bob){ //function for pass by ref as it takes objects
            bob[0] = bob[0] +2;
            return bob[0];
    }
}


//pass by value +1, value me internal chnages hote hai
//pss bt refrence +2 value me ,isme memory ref pass hote hai
