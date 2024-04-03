class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        
        int n = word.length();
        int end = n-1;
        int maxLength = 0;
        
        HashSet<String> forbiddenSet = new HashSet<String>(forbidden);
        
        for(int i=n-1; i>=0; i--){
            for(int j=i; (j<=end && (j-i) <= 10); j++){
                String subword = word.substring(i, j+1);
                if(forbiddenSet.contains(subword)){
                    end = j-1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, end-i+1);
        }
        
        return maxLength;
        
        
        
        
    }
}

// forbidden = 'aaa','cb'
    
// word = 'cbaaaabc'
//                e
//            i
//                j