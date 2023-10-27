class Solution {
    String maxString = "";
    int maxlength = 0;
    public String longestPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1) return s;
        for(int i=0; i<s.length()-1; i++){
            isPalindrome(i,i,s);
            isPalindrome(i, i+1, s);
        }

        return maxString;
        
        
    }

    public void isPalindrome(int i, int j, String s){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxlength < (j-i)){
            maxlength = j-i;
            maxString = s.substring(i+1,j);
        }

    }
}