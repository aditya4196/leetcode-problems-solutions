class Solution {
    public int countHomogenous(String s) {
        int result = 0, count = 0;
        int mod = (int)(Math.pow(10,9)+7);
        
        for(int i=0; i<s.length(); i++){
            if(i == 0 || s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else count = 1;
            
            result = (result + count) % mod;
        }
        
        return result;
        
    }
}