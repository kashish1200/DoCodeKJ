/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        double ans =0;
        Arrays.sort(arr,(a,b)->{
            return Double.compare((double)b.value/(double)b.weight,(double)a.value/(double)a.weight);
        });
        for(int i=0; i<n; i++){
            if(W >= arr[i].weight){
                W -= arr[i].weight;
                ans+= arr[i].value;
            }
            else{
                ans+= (double) W/arr[i].weight * arr[i].value;
                break;
            }
        }
        return ans;     
  }
}
