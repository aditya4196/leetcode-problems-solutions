class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int i=s.length()-1, j=t.length()-1;
        int sb = 0, tb = 0;
        
        while(i>=0 || j>=0){
            
            while(i>=0){
                if(s.charAt(i) == '#'){
                    sb++;
                    i--;
                }
                else if(sb>0){
                    sb--;
                    i--;
                }
                else break;
            }

            while(j>=0){
                if(t.charAt(j) == '#'){
                    tb++;
                    j--;
                }
                else if(tb>0){
                    tb--;
                    j--;
                }
                else break;
            }
            
            if(i>=0 && j>=0 && s.charAt(i) != t.charAt(j)) return false;
            if((i>=0 != j>=0)) return false;
            i--;j--;
        }
        return true;
        
    }
}

/*

 c 
i
sl = 0

d#c
 j
sl = 0


*/