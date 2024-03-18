class Solution {
    public int calculate(String s) {
        
        int num = 0, result = 0,sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            else if(c == '+'){
                result += (num*sign);
                sign = 1;
                num = 0;
            }
            else if(c == '-'){
                result += (num*sign);
                sign = -1;
                num = 0;
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
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        return result + (num*sign);
    }
}