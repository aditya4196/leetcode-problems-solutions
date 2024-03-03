class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return topDown(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
    
    public int topDown(String text1, String text2, int ptr1, int ptr2, Integer[][] dp){
        if(ptr1 < 0 || ptr2 < 0) return 0;
        if(dp[ptr1][ptr2] != null) return dp[ptr1][ptr2];
        
        if(text1.charAt(ptr1) == text2.charAt(ptr2)){
            return dp[ptr1][ptr2] = 1 + topDown(text1, text2, ptr1-1, ptr2-1, dp);
        }
        else return dp[ptr1][ptr2] = Math.max(topDown(text1, text2, ptr1-1, ptr2, dp), topDown(text1, text2, ptr1, ptr2-1, dp));
    }
}

/*

abcde
    i

ace
  j
  

*/