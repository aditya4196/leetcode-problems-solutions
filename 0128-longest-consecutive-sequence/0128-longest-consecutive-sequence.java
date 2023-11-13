class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int longest = 0;
        for(int num : nums) set.add(num);
        
        for(int num : nums){
            if(set.contains(num-1)) continue; 
            int count = 0, currNum = num;
            while(set.contains(currNum++)) count++;
            longest = Math.max(longest, count);
        }
        return longest;
    }
}