class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        
        int w1ptr = 0, w2ptr = 0;
        
        while(w1ptr < word1.length() || w2ptr < word2.length()){
            if(w1ptr < word1.length()){
                result.append(word1.charAt(w1ptr++));
            }
            if(w2ptr < word2.length()){
                result.append(word2.charAt(w2ptr++));
            }
        }
        
        return result.toString();
        
    }
}