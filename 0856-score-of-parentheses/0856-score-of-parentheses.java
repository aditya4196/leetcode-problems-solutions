class Solution {
    public int scoreOfParentheses(String s) {
        
        Deque<Integer> stack = new LinkedList();
        stack.push(0);
        
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(0);
            else{
                int currdepth = stack.pop();
                int adjscore = stack.pop();
                
                stack.push(adjscore + Math.max(2*currdepth,1));
            }
        }
        
        return stack.peek();
        
    }
}