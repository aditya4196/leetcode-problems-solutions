class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()){
            if(c == ')' || c == '}' || c == ']'){
                if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
                if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
                if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            }  
            else stack.push(c);
        }
        
        return stack.isEmpty();
        
    }
}