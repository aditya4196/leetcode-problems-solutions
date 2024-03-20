class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] leftFilledSeat = new int[n];
        int[] rightFilledSeat = new int[n];
        
        Arrays.fill(leftFilledSeat, n);
        Arrays.fill(rightFilledSeat, n);
        
        
        for(int i=0; i<n; i++){
            if(seats[i] == 1){
                leftFilledSeat[i] = 0;
            }
            else if(i > 0) leftFilledSeat[i] = leftFilledSeat[i-1] + 1;
        }
        
        for(int i=n-1; i>=0; i--){
            if(seats[i] == 1) rightFilledSeat[i] = 0;
            else if(i < (n-1)) rightFilledSeat[i] =rightFilledSeat[i+1] + 1;
        }
        
        for(int i=0; i<n; i++){
            System.out.println(leftFilledSeat[i]  + "-" + rightFilledSeat[i]);
        }
        
        int maxDist = 0, minDist = Integer.MAX_VALUE;
    
        
        for(int i=0; i<n; i++){
            if(seats[i] == 0){
                minDist = Math.min(leftFilledSeat[i], rightFilledSeat[i]);
                maxDist = Math.max(maxDist, minDist);
            }    
        }
        
        return maxDist;
        
    }
}

/*
 0 1 2 3 4 5 6
[1,0,0,0,1,0,1]
[0,0,0,0,4,4,6]
[0,4,4,4,4,6,6]


*/