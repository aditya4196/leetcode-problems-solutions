class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        
        List<List<Integer>> result = new ArrayList();
        
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int j=i+1, k=n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while(j<n && nums[j] == nums[j-1]) j++;
                }
                else if(sum < 0) j++;
                else k--;
            }
        }
        
        return result;
        
    }
} 