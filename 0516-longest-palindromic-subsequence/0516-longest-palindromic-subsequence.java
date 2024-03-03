class Solution {
    public int longestPalindromeSubseq(String s) {
        
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray(); 
        reverse(str2);
        
        return topDown(str1, str2, str1.length-1, str2.length-1, new Integer[str1.length][str2.length]);
    }
    
    public int topDown(char[] str1, char[] str2, int ptr1, int ptr2, Integer[][] dp){
        if(ptr1 < 0 || ptr2 < 0) return 0;
        
        if(dp[ptr1][ptr2] != null) return dp[ptr1][ptr2];
        
        if(str1[ptr1] == str2[ptr2]) return dp[ptr1][ptr2] = 1 + topDown(str1, str2, ptr1-1, ptr2-1, dp);
        else{
            return dp[ptr1][ptr2] = Math.max(topDown(str1, str2, ptr1-1, ptr2, dp), topDown(str1, str2, ptr1, ptr2-1, dp));
        }
    }
    
    public void reverse(char[] s){
        int i = 0, j = s.length-1;
        
        while(i < j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}