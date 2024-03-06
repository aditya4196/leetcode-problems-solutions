class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> freq = new HashMap();
        int start = 0, maxLength = 0, dupCount = 0;
        
        for(int end=0; end<s.length(); end++){
            freq.put(s.charAt(end), freq.getOrDefault(s.charAt(end),0)+1);
            if(freq.get(s.charAt(end)) == 2) dupCount++;
            
            while(dupCount > 0){
                freq.put(s.charAt(start), freq.get(s.charAt(start))-1);
                if(freq.get(s.charAt(start)) == 1) dupCount--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
        
        
        
        
    }
}

/*

abcabcbb
i

map = [a]


*/