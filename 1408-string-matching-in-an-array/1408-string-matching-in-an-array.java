class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> result = new ArrayList();

        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(i!=j && isMatched(words[j], words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
    
    //KMP algorithm
    
    public boolean isMatched(String txt, String pat){
        //
        int N = txt.length();
        int M = pat.length();
        int[] lps = new int[pat.length()];
        preprocess(pat, lps);
        
        int j=0, i=0;
        while (i < N) { 
            if (pat.charAt(j) == txt.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
                return true;
            } 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i++; 
            } 
        }
        
        return false;
    }
    
    public void preprocess(String pattern, int[] lps){
        
        int i = 0, j = 1;
        int n = pattern.length();
        lps[0] = 0;
        
        while(j < n){
           if(pattern.charAt(i) == pattern.charAt(j)){
               lps[j] = ++i;
               j++;
           } 
           else{
               if(i == 0){
                   lps[j] = i;
                   j++;
               }
               else{
                  i = lps[i-1]; 
               }
           }
        }
    }
}
