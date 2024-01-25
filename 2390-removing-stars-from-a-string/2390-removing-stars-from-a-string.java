class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()){
            if(c == '*' && !stack.isEmpty()){
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