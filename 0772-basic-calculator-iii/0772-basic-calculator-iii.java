class Solution {
    public int calculate(String s) {
        
        int num = 0, result = 0;
        char op = '+';
        Stack<Pair<Integer, Character>> stack = new Stack<Pair<Integer,Character>>();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            else if(isOperator(c)){
                if(c == '/'){
                    System.out.println(Arrays.asList(stack));
                    System.out.println(op);
                }
                helper(stack, num, op);
                op = c;
                num = 0;
            }
            else if(c == '('){
                stack.push(new Pair<Integer,Character>(null, op));
                op = '+';
                num = 0;
            }
            else if(c == ')'){
                helper(stack, num, op);
                num = 0;
                while(!stack.isEmpty() && stack.peek().getValue() == null){
                    num += stack.pop().getKey();
                }
                op = stack.pop().getValue();
                helper(stack, num, op);  
                op = c;
                num = 0;
                //System.out.println(Arrays.asList(stack));
            }
        }
        helper(stack, num, op);
        while(!stack.isEmpty()){
            result += stack.pop().getKey();
        }
        return result;
        
    }
    
    public void helper(Stack<Pair<Integer, Character>> stack, int num, char op){
        
        if(op == '+'){
            stack.push(new Pair<Integer,Character>(num, null));
        }
        else if(op == '-'){
            stack.push(new Pair<Integer,Character>(-1*num, null));
        }
        else if(op == '/'){
            int popped = stack.pop().getKey();
            stack.push(new Pair<Integer,Character>(popped/num, null));
        }
        else if(op == '*'){
            int popped = stack.pop().getKey();
            stack.push(new Pair<Integer,Character>(popped*num, null)); 
        }
        
    }
    
    public boolean isOperator(char op){
        return (op == '+' || op == '-' || op == '*' || op == '/');
    }
}