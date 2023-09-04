Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true


SOLUTION 1 - BY SORTING O(nlog(n)); 
class Solution {
    public boolean isAnagram(String s, String t) {
        char cs[] = s.toCharArray();
        char ct[] = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        String S = new String(cs);
        String T = new String(ct);
        System.out.println(S + " " + T);
        if(S.equals(T)) return true;
        return false;
    }
}


SOLUTION 2 - BY HASHMAP 0(n)
 class Solution {
 public boolean isAnagram(String s, String t) {                         
 HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        // this istypically used to determine whether all values in the map are zero.
        for(int val : map.values()){
            if(val!=0) return false;
        }
        return true;
        }
}

