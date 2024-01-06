class Solution {
    int totalSubsets = 0;
    
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(nums, 0, k, new ArrayList<Integer>());
        return totalSubsets;
    }
    
    public void backtrack(int[] nums, int idx, int k, List<Integer> set){
        if(idx > 0){
            totalSubsets++;
        }
        
        for(int i=idx; i<nums.length; i++){
            if(set.contains(nums[i]-k)) continue;
            set.add(nums[i]);
            backtrack(nums, i+1, k, set);
            set.remove(set.size()-1);
        }
    }
}