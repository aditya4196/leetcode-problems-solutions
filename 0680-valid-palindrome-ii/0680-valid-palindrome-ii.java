class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length()-1, 0);
    }
    
    public boolean helper(String s, int left, int right, int removed){
        if(removed > 1) return false;
        
        if(left >= right) return true;
        
        if(s.charAt(left) == s.charAt(right)){
            return helper(s, left+1, right-1, removed);
        }
        else return helper(s, left+1, right, removed+1) || helper(s, left, right-1, removed+1);
    }
}

/*
"aba"
 i
  j





*/