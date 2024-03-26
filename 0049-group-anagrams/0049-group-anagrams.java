class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap();
        
        for(String str : strs){
            int[] count = new int[26];
            
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(String.valueOf(count[i]));
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k-> new ArrayList<String>()).add(str);
        }
        
        List<List<String>> result = new ArrayList();
        result.addAll(map.values());
        return result;
        
    }
}