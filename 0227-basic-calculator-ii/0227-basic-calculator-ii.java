class Solution {
    public int calculate(String s) {
        
        int len = s.length();
        int currentNumber = 0;
        char operation = '+';
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                currentNumber = currentNumber*10 + Integer.parseInt(String.valueOf(c));
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == len-1){
                if(operation == '+') stack.push(currentNumber);
                else if(operation == '-') stack.push(-currentNumber);
                else if(operation == '*') stack.push(stack.pop()*currentNumber);
                else if(operation == '/') stack.push(stack.pop()/currentNumber);
                
                operation = c;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
        
        
        
        
    }
}

/*


32 +2* 2
     i

num = 2
stack = ['32','+']
op = '+'

*/