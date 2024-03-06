class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> freq = new HashMap();
        int start = 0, maxOcc = 0, maxLength = 0;
        
        for(int end=0; end<s.length(); end++){
            char c = s.charAt(end);
            freq.put(c, freq.getOrDefault(c,0)+1);
            maxOcc = Math.max(maxOcc,freq.get(c));
            
            while((end-start+1 - maxOcc) > k){
                char d = s.charAt(start);
                // if(maxOcc == freq.get(d)){
                //     maxOcc = freq.get(d)-1;
                // }
                freq.put(d, freq.get(d)-1);
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
        
        
    }
}

/*
0123
ABAB
   i
j

maxOcc = 2

(end-start+1) - maxOcc > k
k = 1

*/