class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        backtrack(s, 0, new ArrayList<String>(), result, new boolean[s.length()][s.length()]);
        return result;
        
    }
    
    public void backtrack(String s, int idx, List<String> inter, List<List<String>> result, boolean[][] dp){
        if(idx == s.length()){
            result.add(new ArrayList<String>(inter));
        }
        
        for(int i=idx; i<s.length(); i++){
            if((s.charAt(idx) == s.charAt(i)) && ((i-idx) <= 2 || dp[idx+1][i-1])){
                dp[idx][i] = true;
                inter.add(s.substring(idx, i+1));
                backtrack(s, i+1, inter, result, dp);
                inter.remove(inter.size()-1);
            }   
        }   
    }
}

/*


                    aab
                
            a,ab
               
           a.  a b
                    





*/