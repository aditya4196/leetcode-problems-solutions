class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> emptyClose = new HashSet<Integer>();
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')'){
                if(stack.isEmpty()) emptyClose.add(i);
                else stack.pop();
            }
        }
        
        StringBuilder result = new StringBuilder(s);
        int n = result.length();
        
        while(!stack.isEmpty()){
            result.deleteCharAt(stack.pop());
        }
        
        for(int i=n-1; i>=0; i--){
            if(emptyClose.contains(i)) result.deleteCharAt(i);
        }
        
        return result.toString();
        
        
        
        
        
    }
}