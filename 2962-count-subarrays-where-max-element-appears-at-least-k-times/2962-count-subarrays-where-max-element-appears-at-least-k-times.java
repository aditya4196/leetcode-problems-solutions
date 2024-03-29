class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int maxCount = 0;
        long result = 0;
        int start = 0;
        
        for(int end = 0; end < nums.length; end++){
            if(nums[end] == maxNum){
                maxCount++;
            }
            
            while(k == maxCount){
                if(nums[start] == maxNum) maxCount--;
                start++;
            }
            
            result += start;
        }
        
        return result;
        
        
        
        
        
    }
}

/*

[1,3,2,3,3]
         e
         s
 
 
stack = [1,3,2]
maxNum = 3
count = 2





*/