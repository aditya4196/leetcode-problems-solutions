class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        Arrays.sort(nums);
        int triplets = 0, n = nums.length;
        
        for(int i=0; i<n-2; i++){
            int j=i+1, k=n-1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum < target){
                    triplets += (k-j);
                    j++;
                }
                else k--;
                
            }
        }
        
        return triplets;
        
    }
}

