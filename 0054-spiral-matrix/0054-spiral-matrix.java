class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rstart = 0;
        int rend = m-1;
        int cstart = 0;
        int cend = n-1;
        
        List<Integer> result = new ArrayList<Integer>();
        
        while(rstart <= rend && cstart <= cend){
            
            for(int i=cstart; i<=cend; i++){
                result.add(matrix[rstart][i]);
            }
            rstart++;
            
            for(int i=rstart; i<=rend; i++){
                result.add(matrix[i][cend]);
            }
            cend--;
            
            if(rstart <= rend && cstart <= cend){
                
                for(int i=cend; i>=cstart; i--){
                    result.add(matrix[rend][i]);
                }
                rend--;
                
                for(int i=rend; i>=rstart; i--){
                    result.add(matrix[i][cstart]);
                }
                cstart++;
            }
        }
        
        return result;
        
    }
}