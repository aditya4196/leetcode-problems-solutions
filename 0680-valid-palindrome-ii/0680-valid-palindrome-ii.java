class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1, 0);
    }
    
    public boolean isPalindrome(String s, int i, int j, int deleteCount){
        
        if(deleteCount == 2) return false;
        
        if(i>=j) return true;
        
        if(s.charAt(i) == s.charAt(j)){
            return isPalindrome(s, i+1, j-1, deleteCount);   
        }
        else{
            return isPalindrome(s, i+1, j, deleteCount+1) || isPalindrome(s, i, j-1, deleteCount+1); 
        }
    }
}