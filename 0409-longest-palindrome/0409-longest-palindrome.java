class Solution {
    public int longestPalindrome(String s) {
        
        Set<Character> set = new HashSet();
        int longest = 0;
        
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                longest +=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        
        return (set.size()>0)?(longest+1):longest;
        
    }
}