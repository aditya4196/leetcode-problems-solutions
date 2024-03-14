class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        Map<Integer, Integer> sumFrequencies = new HashMap();
        int currSum = 0, totalCount = 0;
        
        for(int num : nums){
            currSum += num;
            if(currSum == goal) totalCount++; 
        
            if(sumFrequencies.containsKey(currSum - goal)){
                totalCount += sumFrequencies.get(currSum - goal);
            }
            
            sumFrequencies.put(currSum, sumFrequencies.getOrDefault(currSum, 0) + 1);
        }
        
        return totalCount;
        
       
    }
}


/*

 
[1,0,1,0,1]
       i
currSum = 2
goal = 2

map = [(1,2).(2,2)]



*/