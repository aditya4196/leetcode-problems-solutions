class SparseVector {
    
    Map<Integer, Integer> indexMap;
    
    SparseVector(int[] nums) {
        indexMap = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) indexMap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        
        for(int idx : indexMap.keySet()){
            if(vec.indexMap.containsKey(idx)){
                result += vec.indexMap.get(idx)*indexMap.get(idx);
            }
        }
        
        return result;
        
        
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);