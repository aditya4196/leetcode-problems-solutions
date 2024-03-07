class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int start = 0, result = 0;
        int[] occ = new int[3];
        
        for(int end = 0; end<s.length(); end++){
            occ[s.charAt(end)-'a']++;
            
            while(satisfied(occ)){
                result += (n - end);
                occ[s.charAt(start)-'a']--;
                start++;
            }
        }
        
        return result;  
    }
    
    public boolean satisfied(int[] occ){
        return occ[0] > 0 && occ[1] > 0 && occ[2] > 0;
    }
}

/*

abcabc
  i
j


*/