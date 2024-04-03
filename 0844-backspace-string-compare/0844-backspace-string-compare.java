class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int scount = 0, tcount = 0;
        int sptr = s.length()-1, tptr = t.length()-1;
        
        while(sptr >= 0 || tptr >= 0){
            while(sptr >= 0){
                if(s.charAt(sptr) == '#') scount++;
                else if(scount > 0) scount--;
                else break;
                sptr--;
            }
        
            while(tptr >= 0){
                if(t.charAt(tptr) == '#') tcount++;
                else if(tcount > 0) tcount--;
                else break;
                tptr--;
                
            }
            

            if(tptr >= 0 && sptr >= 0 && t.charAt(tptr) != s.charAt(sptr)) return false;
            if(tptr >= 0 != sptr >= 0) return false;
            tptr--;
            sptr--;

        }
        
        return true;
        
    }
}

/*

a#c 
  i
  
scount = 0
cd#
  j
tcount = 0

*/
