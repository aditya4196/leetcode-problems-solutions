class Solution {
    private String maxString;
    private int maxLength;
    public String longestPalindrome(String s) {
        
        if(s.length() == 0 || s.length() == 1) return s;
        
        int n = s.length();
        for(int i=0; i<n-1; i++){
            isPalindrome(s, i, i);
            isPalindrome(s, i, i+1);
        }
        
        return maxString;
        
    }
    
    public void isPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLength < j-i){
            maxLength = j-i;
            maxString = s.substring(i+1, j);
        }
    }
}