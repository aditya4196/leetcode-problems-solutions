class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack();
        StringBuilder value = new StringBuilder();
        
        StringBuilder input = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c != ' ') input.append(c);
        }
        char prev = '@';
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            
            if(isOperator(c)){
                if(prev == '+'){
                    stack.push(Integer.parseInt(value.toString()));
                }   
                else if(prev == '-'){
                    stack.push(Integer.parseInt(value.toString())*-1);
                }
                else if(prev == '*'){
                    System.out.println("multiply");
                    int prevValue = stack.pop();
                    stack.push(Integer.parseInt(value.toString()) * prevValue);
                }
                else if(prev == '/'){
                    int prevValue = stack.pop();
                    stack.push(prevValue/Integer.parseInt(value.toString()));
                }
                else{
                    stack.push(Integer.parseInt(value.toString()));
                }
                value = new StringBuilder();
                prev = c;
                //System.out.println(Arrays.asList(stack));
            }
            else{
                value.append(c);
            }
        }
        
        if(prev == '@'){
            return Integer.parseInt(value.toString());
        }
        
            if(isOperator(prev)){
                if(prev == '+'){
                    stack.push(Integer.parseInt(value.toString()));
                }   
                else if(prev == '-'){
                    stack.push(Integer.parseInt(value.toString())*-1);
                }
                else if(prev == '*'){
                    System.out.println("multiply");
                    int prevValue = stack.pop();
                    stack.push(Integer.parseInt(value.toString()) * prevValue);
                }
                else if(prev == '/'){
                    int prevValue = stack.pop();
                    stack.push(prevValue/Integer.parseInt(value.toString()));
                }
                else{
                    stack.push(Integer.parseInt(value.toString()));
                }
            }
        
        int result = 0;
        for(int val : stack){
            result += val;
        }
        
        return result;
    }
    
    public boolean isOperator(char op){
        return (op == '/' || op == '+' || op == '*' || op == '-');
    }
}


/*


sign = 1

"3+5/2"
     i

string = "2"
stack = ["3","5","/","2"]




op = "/"


*/