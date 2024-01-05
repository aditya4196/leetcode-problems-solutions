class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList();
        
        for(int i=0; i<n; i++){
            int idx = bsearch(stack,nums[i]);
            if(idx == stack.size()) stack.add(nums[i]);
            else{
                stack.set(idx, nums[i]);
            }
        }
        
        return stack.size();
        
    }
    
    public int bsearch(ArrayList<Integer> stack, int target){
        int left = 0, right = stack.size();
        while(left < right){
            int mid = left + (right-left)/2;
            if(target == stack.get(mid)) return mid;
            else if(target > stack.get(mid)){
                left = mid+1;
            }
            else right = mid;
        }
        return left;
    }
}