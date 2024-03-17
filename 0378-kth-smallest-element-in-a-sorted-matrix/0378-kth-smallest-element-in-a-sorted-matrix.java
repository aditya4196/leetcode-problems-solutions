class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pq.offer(matrix[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }
        
        return pq.peek();
        
        
    }
}

/*
     j
 [1, 5,  9]  
 [2, 7,  10] i
 [12,13,15],


1 -> 2 -> 5

*/