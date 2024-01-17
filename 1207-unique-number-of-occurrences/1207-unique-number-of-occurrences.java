class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> countMap = new HashMap();
        for(int val : arr) countMap.put(val, countMap.getOrDefault(val,0)+1);
        
        Set<Integer> set = new HashSet();
        for(int count : countMap.values()){
            if(set.contains(count)) return false;
            set.add(count);
        }
        
        return true;
        
    }
}