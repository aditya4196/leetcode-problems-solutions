class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            if(isOperator(token)){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(calculate(val2, val1, token));
                
            }
            else{
                Integer val = Integer.parseInt(token);
                stack.push(val);
            }
        }
        
        return stack.pop();
    }
    
    public boolean isOperator(String token){
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    
    public int calculate(int val1, int val2, String exp){
        
        int result = 0;
        switch(exp){
            case "+": 
                result = val1+val2;
                break;
            case "-": 
                result = val1-val2;
                break;
            case "*":
                result = val1*val2;
                break;
            case "/":
                result = val1/val2;
                break;
        }
        
        return result;
    }
}