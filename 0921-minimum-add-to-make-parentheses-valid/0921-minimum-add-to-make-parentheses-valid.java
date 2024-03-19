class Solution {
    public int minAddToMakeValid(String s) {
        int idleClose = 0;
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty()) idleClose++;
                else stack.pop();
            }
        }
        
        return stack.size() + idleClose;

    }
}