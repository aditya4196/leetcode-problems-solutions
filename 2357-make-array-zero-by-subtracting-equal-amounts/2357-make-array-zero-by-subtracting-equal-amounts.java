class Solution {
    public int minimumOperations(int[] nums) {
        
        Set<Integer> set = new HashSet();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                set.add(nums[i]);
            }
        }
        
        return set.size();
        
    }
}

/*

[0,1,3,5,5]
         i

nums[i] - deduct
deduct = 3




*/