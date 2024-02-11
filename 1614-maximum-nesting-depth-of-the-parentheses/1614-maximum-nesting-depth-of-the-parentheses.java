class Solution {
    public int maxDepth(String s) {
        
        int count = 0;
        int maxCount = 0;
        
        for(char c : s.toCharArray()){
            if(c != '(' && c != ')') continue;
            count = (c == '(')?(count+1):(count-1);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
        
        
        
        
        
    }
}