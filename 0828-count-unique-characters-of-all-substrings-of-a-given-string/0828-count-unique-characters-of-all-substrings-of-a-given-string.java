class Solution {
    public int uniqueLetterString(String s) {
        
        int[] lastSeen = new int[26];
        int[] count = new int[26];
        Arrays.fill(lastSeen, -1);
        int localScore = 0, result = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            localScore -= count[c-'A'];
            count[c-'A'] = i - lastSeen[c-'A'];
            localScore += count[c-'A'];
            result += localScore;
            lastSeen[c-'A'] = i;
        }
        
        return result;
        
        
    }
}


/*
 012
'ABC'
   i
  j

012
ABA
  i

  A. B
[ 0, 1]
[ 1, 2]

localscore = 4
finalscore = 7

*/