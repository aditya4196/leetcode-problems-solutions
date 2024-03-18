class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, num = 0, sign = 1;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
                System.out.println(num);
            }
            else if(c == '+'){
                result += num*sign;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += num*sign;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            }
            else if(c == ')'){
                
                result += num*sign;
                num = 0;
                result = result*stack.pop();
                result = result + stack.pop();
            }
        }
        result += num*sign;
        
        return result;
        
        
        
    }
    
    
}