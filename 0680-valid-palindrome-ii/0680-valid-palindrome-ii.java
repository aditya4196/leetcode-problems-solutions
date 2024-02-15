class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        return checkPalindrome(s, 0, n-1, 0);
    }
    
    public boolean checkPalindrome(String s, int i, int j, int count){
        if(count > 1) return false;
        if(i>=j) return true;
        
        if(s.charAt(i) == s.charAt(j)) return checkPalindrome(s, i+1, j-1, count);
        else{
            return  checkPalindrome(s, i+1, j, count+1) || checkPalindrome(s, i, j-1, count+1);
        }
    }
}


/*


a b c a
  i     
    j

           a b c c d a
             b c c d
             
        c c d       b c c
        i.  j       i.  j
      
           c.    b


*/