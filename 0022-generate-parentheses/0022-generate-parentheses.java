class Solution {
    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        helper(n, 0,0, ""); 
        return result;
    }
    
    public void helper(int n, int open, int close, String str){
        if(str.length() == n*2){
            result.add(str);
            return;
        }
        
        if(open < n){
            helper(n, open+1, close, str + "(");
        }
        if(close < open){
            helper(n, open, close+1, str + ")");
        }
    }
}

/*

n = 3

'((()'

open = 3
close = 0




*/