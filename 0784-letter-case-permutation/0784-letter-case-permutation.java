class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList();
        backtrack(new StringBuilder(s), 0, result);
        return result;
    }
    
    public void backtrack(StringBuilder s, int idx, List<String> result){
        result.add(s.toString());

        
        for(int i=idx; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))) continue;
            char c = s.charAt(i);
            if(Character.isUpperCase(s.charAt(i))) s.setCharAt(i,Character.toLowerCase(s.charAt(i)));
            else s.setCharAt(i,Character.toUpperCase(s.charAt(i)));
            backtrack(s, i+1, result);
            s.setCharAt(i,c);
        }
    }
}