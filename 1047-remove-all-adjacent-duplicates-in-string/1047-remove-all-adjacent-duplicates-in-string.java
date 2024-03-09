class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }
            else stack.push(c);
        }
        
        StringBuilder output = new StringBuilder();
        for(char c : stack){
            output.append(c);
        }
        
        return output.toString();
        
        
        
    }
}