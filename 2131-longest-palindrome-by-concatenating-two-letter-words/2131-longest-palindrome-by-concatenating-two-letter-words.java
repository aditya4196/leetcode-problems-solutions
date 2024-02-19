class Solution {
    public int longestPalindrome(String[] words) {
        
        int[][] freq = new int[26][26];
        int longest = 0;
        
        for(String word : words){
            char a = word.charAt(0);
            char b = word.charAt(1);
            
            if(freq[b-'a'][a-'a'] > 0){
                freq[b-'a'][a-'a']--;
                longest+=4;
            }
            else freq[a-'a'][b-'a']++;
        }
        
        boolean central = false;
        for(int i=0; i<26; i++){
            if(freq[i][i] % 2 == 0){
                longest += 2*freq[i][i];
            }
            else{
                longest += 2*(freq[i][i]-1);
                central = true;
            }
        }
        
        return (central)?(longest+2):longest;
        
        
        
    }
}