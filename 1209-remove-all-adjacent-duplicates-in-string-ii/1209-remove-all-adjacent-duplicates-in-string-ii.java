class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair<Character, Integer>> stack = new Stack<Pair<Character, Integer>>();
        if(s.length() == 0 || s.length() < k) return s;
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek().getKey() == c) stack.push(new Pair<Character, Integer>(c, stack.peek().getValue()+1));
            else stack.push(new Pair<Character, Integer>(c, 1));
            
            if(!stack.isEmpty() && stack.peek().getValue() == k){
                for(int j=1; j<=k; j++) stack.pop();
            }
        }
        
        for(Pair<Character, Integer> pair : stack){
            result.append(pair.getKey());
        }
        
        return result.toString();
        
    }
}