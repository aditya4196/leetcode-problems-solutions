class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        
        HashSet<String> forbiddenSet = new HashSet<String>(forbidden);
        int maxLength = 0, n = word.length();
        int end = n-1;
        
        for(int i=n-1; i>=0; i--){
            for(int j=i; (j<=end && (j-i) < 10); j++){
                String checkString = word.substring(i, j+1);
                if(forbiddenSet.contains(checkString)){
                    end = j-1;
                    break;
                }
            }
            
            maxLength = Math.max(maxLength, end-i+1);
        }
        
        return maxLength;
        
    }
}