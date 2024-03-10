class Solution {
    public int calculate(String s) {
        
        Stack<Integer> numstack = new Stack();
        Stack<Character> opstack = new Stack();
        Map<Character, Integer> pref = new HashMap();
        pref.put('+',0);
        pref.put('-',0);
        pref.put('*',1);
        pref.put('/',1);
        
        int num = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' ') continue;
            if(isOperator(c)){
                numstack.push(num);
                num = 0;
                while(!opstack.isEmpty() && pref.get(opstack.peek()) >= pref.get(c)){
                    int val2 = numstack.pop();
                    int val1 = numstack.pop();
                    numstack.push(calculate(opstack.pop(), val1, val2));
                }
                opstack.push(c);
            }
            else{
                num = num*10 + (c-'0');
            }
        }
        
        numstack.push(num);     
        while(!opstack.isEmpty()){
            int val2 = numstack.pop();
            int val1 = numstack.pop();
            numstack.push(calculate(opstack.pop(), val1, val2));
        }
        
        return numstack.pop();
        
        
        
    }
    
    public int calculate(char op, int num1, int num2){
        int result = 0;
        switch(op){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }
    
    public boolean isOperator(char c){
        return (c == '+' || c == '*' || c == '-' || c == '/');
    }
}


/*
"3*2+2"
    i
numstack = [3,2,2]
opstack = [+,*]

*/