class Solution {
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<String>();
        helper(s, 0, 0, 0, new StringBuilder());
        
        int minRemoved = Integer.MIN_VALUE;
        for(String str : set){
            minRemoved = Math.max(minRemoved, str.length());
        }
        
        List<String> result = new ArrayList();
        for(String str : set){
            if(minRemoved == str.length()){
                result.add(str);
            }
        }
        
        return result;
        
    }
    
    public void helper(String s, int idx, int left, int right, StringBuilder str){
        if(idx == s.length()){
            if(left == right){
                set.add(str.toString());
            }
            return;
        }
        
        if(s.charAt(idx) != '(' && s.charAt(idx) != ')'){
            str.append(s.charAt(idx));
            helper(s, idx+1, left, right, str);
            str.deleteCharAt(str.length()-1);
        }
        else{
            helper(s, idx+1, left, right, str);
            str.append(s.charAt(idx));
            
            if(s.charAt(idx) != '('){
                helper(s, idx+1, left+1, right, str);
            }
            else{
                if(left <= right){
                  helper(s, idx+1, left, right+1, str);                   
                }
            }
            str.deleteCharAt(str.length()-1);
        }
         
    }
}