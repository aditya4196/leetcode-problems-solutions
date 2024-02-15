class Solution {
    public String makeSmallestPalindrome(String s) {
        int i=0, j=s.length()-1;
        StringBuilder result = new StringBuilder(s);
        
        while(i < j){
            char a = result.charAt(i);
            char b = result.charAt(j);
            
            if(a != b){
                if(a < b) result.setCharAt(j,a);
                else result.setCharAt(i,b);
            }
            
            i++;
            j--;
        }
        
        return result.toString();
    }
}


/*

e g c f e





*/