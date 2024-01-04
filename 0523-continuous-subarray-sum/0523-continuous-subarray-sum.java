class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Set<Integer> modset = new HashSet<Integer>();
        int prevmod = 0, totalsum = 0, currmod = 0;
        
        for(int num : nums){
            totalsum += num;
            currmod = totalsum % k;
            if(modset.contains(currmod)) return true;
            
            modset.add(prevmod);
            prevmod = currmod;
        }
        
        return false;
    }
}