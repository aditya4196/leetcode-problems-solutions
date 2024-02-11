class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] nums, int idx, List<Integer> inter, List<List<Integer>> result){
        if(idx >= nums.length){
            result.add(new ArrayList<Integer>(Arrays.stream(nums).boxed().toList()));
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            swap(nums, idx, i);
            backtrack(nums, idx+1, inter, result);
            swap(nums, i, idx);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}