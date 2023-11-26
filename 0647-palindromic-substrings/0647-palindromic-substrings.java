class Solution {
    public int countSubstrings(String s) {
        
        int totalPalindromeSubstrings = 0;
        for(int i=0; i<s.length()-1; i++){
            totalPalindromeSubstrings += getPalindromeCount(s, i, i);
            totalPalindromeSubstrings += getPalindromeCount(s, i, i+1);
        }
        return totalPalindromeSubstrings+1;
        
    }
    
    public static int getPalindromeCount(String s, int i, int j){
        int palindromeCount = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            palindromeCount++;
            i--;
            j++;
        }
        
        return palindromeCount;
    }
}