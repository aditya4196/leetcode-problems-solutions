class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> freq = new HashMap();
        int start = 0, distinctCount = 0, maxLength = 0;
        
        for(int end=0; end<s.length(); end++){
            freq.put(s.charAt(end), freq.getOrDefault(s.charAt(end),0)+1);
            if(freq.get(s.charAt(end)) == 1) distinctCount++;
            
            while(distinctCount > 2){
                freq.put(s.charAt(start), freq.get(s.charAt(start))-1);
                if(freq.get(s.charAt(start)) == 0) distinctCount--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
        
        
        
        
    }
}

/*





*/