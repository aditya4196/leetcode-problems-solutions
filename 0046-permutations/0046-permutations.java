class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        recursion(nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return output;
    }

    public void recursion(int[] nums, List<Integer> inner, Set<Integer> present){
        if(inner.size() == nums.length){
            output.add(new ArrayList<Integer>(inner));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!present.contains(nums[i])){
                inner.add(nums[i]);
                present.add(nums[i]);
                recursion(nums, inner, present);
                present.remove(nums[i]);
                inner.remove(inner.size()-1);
            }
        }

    }
}