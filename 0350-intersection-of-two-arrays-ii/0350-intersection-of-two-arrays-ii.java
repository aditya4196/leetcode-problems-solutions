class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> freq = new HashMap();
        
        for(int num : nums1){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        
        List<Integer> result = new ArrayList();
        
        for(int num : nums2){
            if(freq.containsKey(num)){
                result.add(num);
                freq.put(num, freq.get(num)-1);
                if(freq.get(num) == 0) freq.remove(num);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
}

