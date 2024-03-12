class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        Integer[][] dp = new Integer[nums1.length][2];
        return backTrack(nums1, nums2, 0, 0, dp);
    }
    
    public int backTrack(int[] nums1, int[] nums2, int idx, int swapped, Integer[][] dp){
        if(idx == nums1.length) return 0;
        
        
        int prev1 = -1;
        int prev2 = -1;
        
        if(idx > 0){
            prev1 = nums1[idx-1];
            prev2 = nums2[idx-1];
        }
        
        if(dp[idx][swapped] != null) return dp[idx][swapped];
        
        if(swapped == 1){
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }
        
        int result = Integer.MAX_VALUE;
        //noswap
        if(nums1[idx] > prev1 && nums2[idx] > prev2){
            result = backTrack(nums1, nums2, idx+1, 0, dp);
        }
        
        //swap
        if(nums1[idx] > prev2 && nums2[idx] > prev1){
            result = Math.min(result, backTrack(nums1, nums2, idx+1, 1, dp) + 1);
        }
        
        return dp[idx][swapped] = result;
    }
}