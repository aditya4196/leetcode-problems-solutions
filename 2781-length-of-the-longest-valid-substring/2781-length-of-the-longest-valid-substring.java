class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        
        int n = word.length();
        HashSet<String> forbiddenSet = new HashSet<String>(forbidden);
        int end = n-1;
        int maxLength = 0;
        int i=0, j=0;
        
        for(i=n-1; i>=0; i--){
            for(j=i; ((j-i) < 10) && (j<=end); j++){
                String toCheck = word.substring(i, j+1);
                if(forbiddenSet.contains(toCheck)){
                    end = j-1;
                    break;
                }
            }
            
            maxLength = Math.max(maxLength, end-i+1);
            
            
            
        }
        
        return maxLength;
        
        
    }
}


/*

cbaaaabc
 i
 j
   e

3

*/