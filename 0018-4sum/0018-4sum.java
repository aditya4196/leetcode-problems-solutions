class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        kSum(nums, 0, target, 4, new ArrayList<Integer>(), result);
        return result;
        
    }
    
    public void kSum(int[] nums, int idx, long target, int k, List<Integer> quad, List<List<Integer>> result){
        
        if(k == 2){
            int left = idx, right = nums.length-1;
            
            while(left < right){
                long sum = nums[left] + nums[right];
                if(sum == target){
                    quad.add(nums[left]);
                    quad.add(nums[right]);
                    result.add(new ArrayList<Integer>(quad));
                    quad.remove(quad.size()-1);
                    quad.remove(quad.size()-1);
                    
                    left++; right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
                else if(sum < target) left++;
                else right--;
            }
            return;
        }
        
        for(int i=idx; i<=nums.length-k; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            quad.add(nums[i]);
            kSum(nums, i+1, target - nums[i], k-1, quad, result);
            quad.remove(quad.size()-1);
        }
        
    }
}