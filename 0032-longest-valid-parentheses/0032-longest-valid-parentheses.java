class Solution {
    public int longestValidParentheses(String s) {
        
        int left = 0, right = 0, maxLength = 0;
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) maxLength = Math.max(maxLength, 2*right);
            else if(left < right){
                left = 0;
                right = 0;
            }
        }
        
        left = right = 0;
        for(int i=s.length()-1; i >=0 ; i--){
            if(s.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) maxLength = Math.max(maxLength, 2*left);
            else if(left > right){
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
        
        
    }
}