class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack();
        StringBuilder result = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == '*') stack.pop();
            else{
                stack.push(c);
            }
        }
        
        
        
        for(char c : stack){
            result.append(c);    
        }
        return result.toString();
        
    }
}