class Solution {
    public int minInsertions(String s) {
        
        Deque<Character> stack = new LinkedList();
        int inserts = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                if(stack.isEmpty()){
                   stack.push(c); 
                }
                else{
                    if(stack.peek() == ')'){
                        inserts++;
                        stack.pop();
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
            else{
                if(stack.isEmpty()){
                    inserts++;
                    stack.push('(');
                    stack.push(c);
                }
                else{
                    if(stack.peek() == '('){
                        stack.push(c);
                    }
                    else{
                        stack.pop();
                        stack.pop();
                    }
                }
                
            }
        }
        
        if(stack.isEmpty()) return inserts;
        else{
            while(!stack.isEmpty()){
                char c = stack.pop();
                if(c == '('){
                    inserts += 2;
                }
                else{
                    inserts++;
                    stack.pop();
                }
            }
        }
        
        return inserts;
        
        
        
        
        
    }
}

/*
(()))

stack = ['))',]


*/