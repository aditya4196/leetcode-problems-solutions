class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder input = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c)){
                input.append(Character.toLowerCase(c));
            }
            else if(Character.isDigit(c)){
                input.append(c);
            }
        }

               
        int i=0, j=input.length()-1;
               
        while(i<j){
            if(input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
        
        
        
    }
}