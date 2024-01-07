class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
            }
            else if(s.charAt(i) == '('){
                stack.push(i);
            }
        }
        
        
        StringBuilder temp = new StringBuilder(s);
        
        while(stack.size() > 0){
            temp.deleteCharAt(stack.pop());
        }
        
        return temp.toString();
        
    }
}

/*


l e e ( t ( c ) o ) d e )

) ( )

) ( )

stack = [3 5 7]


*/