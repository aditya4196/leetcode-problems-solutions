class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        Map<Pair<Integer, Integer>, Integer> map = new HashMap();
        return topDown(nums, target, 0, map);
    }
    
    public int topDown(int[] nums, int target, int idx, Map<Pair<Integer,Integer>,Integer> memo){
        if(idx == nums.length && target == 0) return 1;
        if(idx >= nums.length) return 0;
        
        if(memo.containsKey(new Pair(idx, target))) return memo.get(new Pair(idx, target));
        
        
        int added = topDown(nums, target - nums[idx], idx+1, memo);
        int subtracted = topDown(nums, target + nums[idx], idx+1, memo);
        
        int total = added + subtracted;
        memo.put(new Pair(idx, target),total);
        return total;
    }
}