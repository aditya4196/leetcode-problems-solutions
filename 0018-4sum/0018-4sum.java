class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        this.result = new ArrayList();
        if(nums.length < 4) return result;
        Arrays.sort(nums);
        long tgt = target;
        helper(nums, tgt, 0, 4, new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int[] nums, long target, int idx, int k, List<Integer> quad){
        if(k == 2){
            twoSum(nums, target, idx, quad);
            return;
        }
        
        for(int i=idx; i<nums.length-k+1; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            quad.add(nums[i]);
            helper(nums, target - nums[i], i+1, k-1, quad);
            quad.remove(quad.size()-1);
        }
    }
    
    public void twoSum(int[] nums, long target, int left, List<Integer> quad){
        int right = nums.length-1;
        
        while(left < right){
            long sum = nums[left] + nums[right];
            if(sum == target){
                quad.add(nums[left]);
                quad.add(nums[right]);
                result.add(new ArrayList<Integer>(quad));
                quad.remove(quad.size()-1);
                quad.remove(quad.size()-1);
                left++;
                
                while(left < right && nums[left] == nums[left-1]) left++;
            }
            else if(sum > target){
                right--;
            }
            else left++;
        }
    }
    
    
    
    
    
    
}

/*

[1,0,-1,0,-2,2]
 i
 
                        (0,4)
                    
                    (1,3)   (0,4)

                (1,2)  (1,3)

                    (0,2)  (1,3)
                
                [2sum]
               (0,-2,2)

*/