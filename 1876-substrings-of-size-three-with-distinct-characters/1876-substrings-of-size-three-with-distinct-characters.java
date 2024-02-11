class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length()-2; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);
            if((a!=b) && (b!=c) && (a!=c)) count++;
        }
        
        return count;
    }
}


/*


owuxoelszb
  i
j

o - 1
w - 1
u - 1
*/