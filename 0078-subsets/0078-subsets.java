class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] nums, int idx, List<Integer> inter, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(inter));
        
        for(int i=idx; i<nums.length; i++){
            inter.add(nums[i]);
            backtrack(nums, i+1, inter, result);
            inter.remove(inter.size()-1);
        }
    }
}