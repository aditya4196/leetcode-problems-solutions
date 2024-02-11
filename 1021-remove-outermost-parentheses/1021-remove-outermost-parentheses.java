class Solution {
    public String removeOuterParentheses(String s) {
        
        int paranCount = 0;
        String result = "";
        
        int start = 0;
        for(int end=0; end<s.length(); end++){
            paranCount = (s.charAt(end) == '(')?(paranCount+1):(paranCount-1);
            if(paranCount == 0){
                result += s.substring(start+1,end);
                start = end+1;
            }
        }
        
        return result;
        
    }
}


/*

( ( ) ( ) ) ( ( ) )
i
          j
count = 0


*/