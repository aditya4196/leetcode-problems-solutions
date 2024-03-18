class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char op = '+';
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (int)(c-'0');
            }
            else if(isOperator(c)){
                helper(stack, num, op);
                op = c;
                num = 0;
            }
        }
        helper(stack, num, op);
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    
    public void helper(Stack<Integer> stack, int num, char op){
        if(op == '+'){
            stack.push(num);
        }
        else if(op == '-'){
            stack.push(-1*num);
        }
        else if(op == '*'){
            stack.push(stack.pop()*num);
        }
        else if(op == '/'){
            stack.push(stack.pop()/num);
        }
    }
    
    
    
    public boolean isOperator(char op){
        return (op == '+' || op == '-' || op == '*' || op == '/');
    }
}