// class Solution {
//     public int characterReplacement(String s, int k) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         int i=0, j=0, n = s.length(), windowSize=0,maxFreq =0, maxLength=0;
//         while(j<n){
//             windowSize = j-i+1;
//             while(windowSize - maxFreq > k){
//                 int count = map.get(s.charAt(i));
//                 if(count > 1){  
//                     map.put(s.charAt(i), count -1);
//                     i++;
//                 }
//             }
//             map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
//             maxFreq = Collections.max(map.values());
//             maxLength = Math.max(maxLength, windowSize);
//             j++;
//         }
//         return maxLength;
//     }
// }


class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, maxFreq = 0, maxLength = 0, n = s.length();

        while (j < n) {
            char ch = s.charAt(j);

            // expand window
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            // shrink window
            while ((j - i + 1) - maxFreq > k) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }

            // update result
            maxLength = Math.max(maxLength, j - i + 1);

            j++; // don't forget this!
        }

        return maxLength;
    }
}

