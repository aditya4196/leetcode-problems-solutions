class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        
        for(int i=n-1; i>=0; i--){
            if(words[i].length() > 0) return words[i].length();
        }
        
        return 0;
        
    }
}