class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();     
        topDown(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    public void topDown(String s, int idx, List<String> sublist, List<List<String>> result){
        if(idx >= s.length()){
            result.add(new ArrayList<String>(sublist));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                sublist.add(s.substring(idx, i+1));
                topDown(s, i+1, sublist, result);
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