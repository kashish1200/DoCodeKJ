class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String> > map = new HashMap<>();
        for(String ele: s){
            char[] charS = ele.toCharArray();
            Arrays.sort(charS);
            String srted = new String(charS);
            if(!map.containsKey(srted)){
                map.put(srted, new ArrayList<>());
            }
            map.get(srted).add(ele);
        }
        result.addAll(map.values());
        return result;
        
    }
}

Time Complexity: O(n * k log k)
Space Complexity: O(n * k)
