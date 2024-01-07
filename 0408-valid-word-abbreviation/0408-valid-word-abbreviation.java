class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int p=0, q=0;
        
        while(p<word.length() && q<abbr.length()){
            char w = word.charAt(p);
            char a = abbr.charAt(q);
            
            if(w == a){
                p++;
                q++;
            }
            else if(Character.isDigit(a)){
                int left = q;
                if(a-'0' == 0) return false;
                
                while(q < abbr.length() && Character.isDigit(abbr.charAt(q))){
                    q++;
                }
                int num = Integer.parseInt(abbr.substring(left,q));

                if(num > word.length()-p) return false;
                p+=num;
            }
            else return false;
        }
        
        return p == word.length() && q == abbr.length();
        
    }
}