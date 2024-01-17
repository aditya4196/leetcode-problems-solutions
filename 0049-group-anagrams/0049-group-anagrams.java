class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            map.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(str);
        }
        
        result.addAll(map.values());
        return result;
        
    }
}