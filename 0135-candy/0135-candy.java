class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2Right = new int[n];
        int[] right2Left = new int[n];
        
        Arrays.fill(left2Right,1);
        Arrays.fill(right2Left,1);
        
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                left2Right[i] = left2Right[i-1] + 1;
            }
        }
        
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                right2Left[i] = right2Left[i+1] + 1;
            }
        }
        
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        
        return sum;
        
    }
}