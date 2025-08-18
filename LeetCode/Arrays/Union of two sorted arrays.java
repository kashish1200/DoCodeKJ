class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        int n1 = a.length;
        int n2 = b.length;
        while(i<n1 && j<n2){
            if(a[i]==b[j]){
                if(ans.isEmpty() || ans.get(ans.size()-1)!=a[i]){
                    ans.add(a[i]);
                }
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                if(ans.isEmpty() || ans.get(ans.size()-1)!=a[i]){
                    ans.add(a[i]);
                }
                i++;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size()-1)!=b[j]){
                    ans.add(b[j]);
                }
                j++;
            }
        }
        while(i<n1){
            if(ans.isEmpty() || ans.get(ans.size()-1)!=a[i]){
                ans.add(a[i]);
            }
            i++;
        }
        while(j<n2){
            if(ans.isEmpty() || ans.get(ans.size()-1)!=b[j]){
                ans.add(b[j]);
            }
            j++;
        }
        return ans;
    }
    
}
