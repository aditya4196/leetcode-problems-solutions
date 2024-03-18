class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[1]));
        int k = Integer.MIN_VALUE, result = 0;
        
        for(int i=0; i<intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if(x >= k) k = y;
            else result++;
        }
        
        return result;
    }
}

/*

[[1,2],[1,3],[2,5],[3,4],[4,6]
[1,2][2,3][3,5]
   1

k = 2
   
[1,2],[2,3]
  0.    1
  
  
 [[1,2],[1,2],[1,2]]
   [1,2][1,2]
     
 
*/