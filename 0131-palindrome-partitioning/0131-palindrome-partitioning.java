class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList();
        backtrack(s, 0, new ArrayList<String>(), result);
        return result;
        
    }
    
    public void backtrack(String s, int idx, List<String> inter, List<List<String>> result){
        if(idx == s.length()){
            result.add(new ArrayList<String>(inter));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(checkPalindrome(s, idx, i)){
                inter.add(s.substring(idx, i+1));
                backtrack(s, i+1, inter, result);
                inter.remove(inter.size()-1);
            }
        }
        
        
        
        
        
        
    }
    
    public boolean checkPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

/*


                    aab
                
            a,ab
               
           a.  a b
                    





*/