//TC = O(n log n) SC - O(n)
class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int cost = 0;
        //sabse pehle arr ke saare elements heap me daalo
        for(int i=0;i<arr.length;i++){
            minheap.add(arr[i]);
        }
        
        //step 1-  2 smallest length ke ropes nikalo(used minheap for that..a&b smallest nikal jyega by popping from minheap)
        //step 2 - fir a+b hmara sum hoga usko cost me bhi jodna hai and wapas heap me bhi dalna hai
        //step 3 - at the end jab sirf ek element bache heap me tab ruk jana hai(last ke 2 elements ka sum hoga jo heap me dalega..stop there)
        //return cost
        while(minheap.size()>1){
            int a = minheap.poll();
            int b = minheap.poll();
            int sum = a + b;
            minheap.add(sum);
            cost +=sum;
        }
        return cost;
    }
}
