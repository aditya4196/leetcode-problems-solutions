class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int leftSum = 0;
        
        
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        int maxScore = leftSum;
        
        int n = cardPoints.length;
        System.out.println(leftSum);

        for(int j=k-1; j>=0; j--){
            leftSum = leftSum - cardPoints[j] + cardPoints[n-k+j];
            maxScore = Math.max(maxScore, leftSum);
        }
        
        return maxScore;
     
    }

}


/*


k = 7

[9,7,7,9,7,7,9]

sum = 55

[1,2,3,4,5,6,1]

sum = 12
if(i == j){
 
}



*/
