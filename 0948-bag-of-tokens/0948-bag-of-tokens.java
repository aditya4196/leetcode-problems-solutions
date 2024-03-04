class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int i=0, j=tokens.length-1;
        int maxScore = 0;
        int score = 0;
        
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i++];
                score++;
                maxScore = Math.max(maxScore, score);
            }
            else{
                if(score == 0) return maxScore;
                else{
                    power += tokens[j--];
                    score--;
                }
            }
        }
        
        return maxScore;
        
    }
}

/*


100, 200, 300, 400
           i
           j
    
    
power = 300
score = 1



*/