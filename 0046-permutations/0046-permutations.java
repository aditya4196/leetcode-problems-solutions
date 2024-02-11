class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<List<Integer>> result = new ArrayList();
        
        backtrack(nums, set, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] nums, Set<Integer> set, List<Integer> inter, List<List<Integer>> result){
        if(inter.size() == nums.length){
            result.add(new ArrayList<Integer>(inter));
            return;
        }
        
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
                inter.add(num);
                backtrack(nums, set, inter, result);
                inter.remove(inter.size()-1);
                set.remove(num);
            }
        }
    } 
}


/*
*/