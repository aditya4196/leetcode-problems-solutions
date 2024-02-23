class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int pairCount = 0;
        StringBuilder suffix;
        StringBuilder prefix;
        
        Map<String, Integer> map = new HashMap();
        
        
        for(int i=0; i<words.length; i++){
            suffix = new StringBuilder();
            prefix = new StringBuilder();
            String word = words[i];
            
            System.out.println("Iteration - " + i);
            int j=0; 
            int k=word.length()-1;
            
            while(j<word.length() && k>=0){
                suffix.append(word.charAt(k));
                prefix.append(word.charAt(j));
                
                System.out.println(reverse(suffix.toString()) + "-" + prefix.toString());
                
                if(prefix.toString().equals(reverse(suffix.toString())) && map.containsKey(prefix.toString())){
                        System.out.println("count incr");
                        pairCount+=(map.get(prefix.toString()));
                }
                j++;
                k--;
            }
            map.put(words[i], map.getOrDefault(words[i],0)+1);
            
        }
        
        return pairCount;
        
        
        
    }
    
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}

/*


"a","aa","abab","ababab"

 1.   2.   3.     5
 
 
 set = (a, aa, aba, ababa)
 
 
 ababab
 i   
      j
 


*/