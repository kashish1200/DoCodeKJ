//TC - O(n), space O(n)
class Solution {
    public int firstUniqChar(String s) {
        //solved using queue
        Queue<Integer> que = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            //que me indexes store
            if(!map.containsKey(s.charAt(i))){
                que.add(i);
            }
            //map me freq store of char
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

            //front element in the que (jo ki index hai..us index ka char "s.charAt(que.peek))" ..kya uski freq more than 1 h? Agar hai toh remove kro
            while(!que.isEmpty() && map.get(s.charAt(que.peek())) >1){
                que.remove();
            }
        }

        return que.isEmpty() ? -1 : que.peek();
    }
}
