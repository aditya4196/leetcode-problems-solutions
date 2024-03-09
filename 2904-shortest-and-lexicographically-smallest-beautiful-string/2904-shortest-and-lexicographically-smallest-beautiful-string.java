class Solution {
    String minString = "";
    int minLength = Integer.MAX_VALUE, start = 0;
    
    public String shortestBeautifulSubstring(String s, int k) {
        
        int ones = 0;
        for(int end=0; end<s.length(); end++){
            if(s.charAt(end) == '1') ones++;
            
            while(ones == k){
                setSmallerString(s.substring(start,end+1));
                if(s.charAt(start) == '1') ones--;
                start++;
            }
        }
        
        return minString;
        
    }
    
    public void setSmallerString(String s){
        int len = s.length();
        
        if(len < minLength){
            minLength = len;
            minString = s;
        }
        else if(len == minLength){
            for(int i=0; i<minLength; i++){
                if(s.charAt(i)-'0' < minString.charAt(i) - '0'){
                    minString = s;
                    minLength = len;
                    break;
                }
                else if(s.charAt(i) - '0' > minString.charAt(i)-'0') break;
            }
        }
    }
}

/*
012345678
100011001
        e
    s


onecount = 3
k = 3

minLength = 5
minString = "100011"


*/