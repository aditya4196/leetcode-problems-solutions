class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0; i<m; i++){
            int j=0, k=n-1;
            while(j<k){
                int temp2 = matrix[i][j];
                matrix[i][j++] = matrix[i][k];
                matrix[i][k--] = temp2;
                
            }
        }
        
    }
}