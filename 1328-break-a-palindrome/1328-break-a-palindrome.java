class Solution {
    public String breakPalindrome(String palindrome) {
        
        StringBuilder result = new StringBuilder(palindrome);
        
        if(result.length() == 1){
            return "";
        }
        
        boolean updated = false;
        int i=0, j=result.length()-1;
        
        while(i<j){
            if(result.charAt(i) == result.charAt(j)){
                if(result.charAt(i) != 'a'){
                    result.setCharAt(i,'a');
                    return result.toString();
                }
            }
            i++;
            j--;
        }
        
        
        result.setCharAt(result.length()-1,'b');
        return result.toString();
        
        
    }
}

/*

aaaaa


*/