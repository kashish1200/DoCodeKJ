very similar to  -  Maximum Sum of Distinct Subarrays With Length K (Arrays)

  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0, j=0, n= s.length(), count=0, maxCount=0;
        while(j<n){
          //when set contains the element, remove the elements from Set until you remove the duplicate element
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            //when Set contains distinct elements, add kro and max nikalo
            set.add(s.charAt(j));
            maxCount= Math.max(maxCount, set.size());
            j++;
        }
        return maxCount;
    }
}

// Complexity
// Time complexity: O(n)
// Space complexity: O(1)
