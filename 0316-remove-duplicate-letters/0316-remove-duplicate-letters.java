class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastSeen = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            lastSeen[s.charAt(i)-'a'] = i; 
        }
        
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            
            if(seen[curr-'a']) continue;
            
            while(!stack.isEmpty() && curr < stack.peek() && lastSeen[stack.peek()-'a'] > i){
                seen[stack.pop()-'a'] = false;
            }
            seen[curr-'a'] = true;
            stack.push(curr);
            
        }
        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }
        return result.toString();
        
    }
}

/*

b c a b c
0 1 2 3 4
    i
    p

count = [b-1,c-1,a-0]














*/