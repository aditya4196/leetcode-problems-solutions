class Solution {
    public int numTrees(int n) {
        Map<Pair<Integer,Integer>, Integer> cache = new HashMap();
        return helper(1, n, cache);
    }
    
    public int helper(int start, int end, Map<Pair<Integer,Integer>, Integer> cache){
        if(start > end){
            return 1;
        }
        
        Integer cachedCount = cache.getOrDefault(new Pair<Integer,Integer>(start,end), null);
        if(cachedCount != null) return cachedCount;
        
        int totalCount = 0;
        
        for(int curr = start; curr <= end; curr++){
            int leftCount = helper(start, curr-1, cache);
            int rightCount = helper(curr+1, end, cache);
            
            totalCount += leftCount*rightCount;
            
        }
        
        cache.put(new Pair<Integer,Integer>(start,end), totalCount);
        return totalCount;
    }
}

/*

                2
              1.   
            




*/