class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int onescount = 0;
        int maxCount = 0;
        
        for(int num : nums){
            if(num == 0) onescount = 0;
            else onescount++;
            maxCount = Math.max(maxCount, onescount);
        }
        return maxCount;
    }
}