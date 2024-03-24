class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int maxScore = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        if(k == cardPoints.length) return sum;
        
        maxScore = sum;
        int i = cardPoints.length-1;
        for(int j=k-1; j>=0; j--){
            
            sum += cardPoints[i];
            sum -= cardPoints[j];
            System.out.println(sum);
            maxScore = Math.max(sum, maxScore);
            i--;
        }
        
        return maxScore;

    }
}

/*


score = 12
max = 12

[9,7,7,9,7,7,9] 
 i
             j

k > 1


*/