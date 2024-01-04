class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> countmap = new HashMap();
        int maxCount = 0;
        
        for(int num : nums){
            countmap.put(num, countmap.getOrDefault(num,0)+1);
            maxCount = Math.max(maxCount, countmap.get(num));
        }
        
        int[] freq = new int[maxCount+1];
        int[] dp = new int[maxCount+1];
        
        for(int val : countmap.values()){
            if(val == 1) return -1;
            freq[val]+=1;
        }
        
        if(maxCount == 2) return freq[2];
        if(maxCount == 3) return freq[3] + freq[2];
        
        dp[1] = dp[2] = dp[3] = 1;
        
        for(int i=4; i<=maxCount; i++){
            dp[i] = Math.min(dp[i-2],dp[i-3])+1;
        }
    
        
        int totalops = 0;
        for(int i=0; i<freq.length; i++){
            totalops += (dp[i]*freq[i]);
        }
        
        return totalops;
        
    }
}
