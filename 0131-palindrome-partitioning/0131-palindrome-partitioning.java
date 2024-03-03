class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        
        topDown(s, 0, new ArrayList<String>(), result, dp);
        return result;
    }
    
    public void topDown(String s, int idx, List<String> sublist, List<List<String>> result, boolean[][] dp){
        if(idx >= s.length()){
            result.add(new ArrayList<String>(sublist));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            if((s.charAt(idx) == s.charAt(i) &&  ((i - idx) <= 2 || dp[idx+1][i-1] == true))){
                dp[idx][i] = true;
                sublist.add(s.substring(idx, i+1));
                topDown(s, i+1, sublist, result, dp);
                sublist.remove(sublist.size()-1);
            }
        }
        
        
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}

/*

                a a b
                
        a.         a.     b

   a a.   a b



*/