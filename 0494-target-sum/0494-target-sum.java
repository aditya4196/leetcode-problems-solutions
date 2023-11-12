class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Pair<Integer, Integer>, Integer> cache = new HashMap();
        return helper(nums, 0, target, cache);
    }
    
    public int helper(int[] nums, int idx, int target, Map<Pair<Integer, Integer>, Integer> cache){
        if(idx >= nums.length && target == 0) return 1;
        if(idx >= nums.length) return 0;
        
        if(cache.containsKey(new Pair(idx, target))) return cache.get(new Pair(idx, target));
        
        int addOp = helper(nums, idx+1, target + nums[idx], cache);
        int minOp = helper(nums, idx+1, target - nums[idx], cache);
        
        int result = addOp + minOp;
        cache.put(new Pair(idx, target), result);
        return result;
    }
}