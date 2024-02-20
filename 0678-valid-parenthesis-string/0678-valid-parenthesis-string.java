class Solution {
    public boolean checkValidString(String s) {
        
        int open = 0, close = 0;
        
        for(char c: s.toCharArray()){
            open += (c == '(')?1:-1;
            close += (c != ')')?1:-1;
            if(close < 0) break;
            open = Math.max(open, 0);
        }
        
        return open == 0;
        
    }
}