class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> indexMap = new HashMap();

        int count = 0;
        int sum = 0;
        indexMap.put(0,1);
        
        for(int i=0; i<n; i++){
             sum += nums[i];
             if(indexMap.containsKey(sum - k)){
                 count += indexMap.get(sum-k);
             }
            
            indexMap.put(sum, indexMap.getOrDefault(sum,0)+1);
        
        }
        
        return count;
        
      
        
        
    }
}

/*

[1,2,3]

 0 1 2 3
[0,1,3,6]

hashmap = 

j -  = k



 sum = 3
 
 count = 1




*/