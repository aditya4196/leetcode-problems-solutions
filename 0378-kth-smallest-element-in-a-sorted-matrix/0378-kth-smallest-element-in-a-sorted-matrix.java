class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
       int m = matrix.length, n = matrix[0].length;
        
       PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               int x1 = a[0], x2 = a[1], y1 = b[0], y2 = b[1];
               if(matrix[x1][x2] == matrix[y1][y2]){
                   return x1 - x2;
               }
               else return matrix[x1][x2] - matrix[y1][y2];
           }
       });
        
    
      for(int j=0; j<m; j++){
          pq.offer(new int[]{j,0});
      }
        
      int[] curr = new int[2];
      int count = k;
      while(pq.size() > 0 && count > 0){
          curr = pq.poll();
          count--;
          
          int x = curr[0], y = curr[1];
          if(y < (n-1)) pq.offer(new int[]{x,y+1});
      }
        
      return matrix[curr[0]][curr[1]];
        
      
        
        
        
    }
    
    public boolean isValidBounds(int i, int j, int m, int n){
        return (i>=0 && j>=0 && i<m && j<n);
    }
}

/*
     j
 [1,3,5]  
 [6,7,12] i
 [11,14,14],


pq = [1] -> [3,6] -> [6,5,7] -> [6,7,12] -> [7,12,11] -> [7]

1,2,5,7,



*/