class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap();
        
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        
        int longest = 0;
        boolean middleUsed = false;
        
        for(int count : freq.values()){
            if(count %2 == 0){
                longest += count;
            }
            else{
                if(!middleUsed){
                    longest += count;
                    middleUsed = true;
                }
                else{
                    longest += (count-1);
                }
            }
        }
        
        return longest;
        
    }
}