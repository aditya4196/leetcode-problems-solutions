class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] givenCandies = new int[n];
        Arrays.fill(givenCandies,1);
        boolean hasChanged = true;
        
        while(hasChanged){
            
            hasChanged = false;
            for(int i=0; i<ratings.length; i++){
                if(i>0 && ratings[i] > ratings[i-1] && givenCandies[i] <= givenCandies[i-1]){
                    givenCandies[i] = givenCandies[i-1] + 1;
                    hasChanged = true;
                }
                if(i<ratings.length-1 && ratings[i] > ratings[i+1] && givenCandies[i] <= givenCandies[i+1]){
                    givenCandies[i] = givenCandies[i+1] + 1;
                    hasChanged = true;
                }  
            }
        }
        
        int totalCandies = 0;
        for(int candy : givenCandies) totalCandies += candy;
        
        return totalCandies;
        
        
        
        
        
    }
}

/*

[1,0,2]
[1,1,1]
   


 
 [0,1,2]
  j
  
 [1,2,2]
 
 [1,2,2]
 
 [1,2,1]
 
 




*/