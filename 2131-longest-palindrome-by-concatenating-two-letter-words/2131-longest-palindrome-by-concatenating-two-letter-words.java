class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> map = new HashMap();
        for(String word : words) map.put(word, map.getOrDefault(word,0)+1);
        boolean central = false;
        int longest = 0;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();
            
            if(word.charAt(0) == word.charAt(1)){
                if(count%2 == 0){
                    longest += (2*count);
                }
                else{
                    longest += (2*(count-1));
                    central = true;
                }
            }
            else{
                String rev = "" + word.charAt(1) + word.charAt(0);
                if(map.containsKey(rev)){
                    longest += 2*Math.min(count, map.get(rev));
                }
            }
        }
        
        if(central){
            longest+=2;
        }
        
        return longest;
        
    }
}