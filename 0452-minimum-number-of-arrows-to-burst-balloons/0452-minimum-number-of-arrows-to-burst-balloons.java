class Solution {
    public int findMinArrowShots(int[][] points) {
        //Arrays.sort(points,(a,b) -> ((a[0] == Integer.MIN_VALUE || b[0] == Integer.MAX_VALUE)?(-1):(a[0] - b[0])));
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] point = points[0];
        int count = 1;
        
        for(int i=0; i<points.length; i++){
            
            if(point[1] >= points[i][0]){
                point[0] = Math.max(point[0], points[i][0]);
                point[1] = Math.min(point[1], points[i][1]);
            }
            else{
                point = points[i];
                count++;
            }
        }
        
        return count;
    }
}

/*


[10,16],[2,8],[1,6],[7,12]

[1,6][2,8][7,12][10,16]

  [2,6][10,12]


*/