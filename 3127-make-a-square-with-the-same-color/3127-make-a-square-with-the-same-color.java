class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[i].length; j++){
                int bCount = 0, wCount = 0; 
                if(grid[i][j] == 'W'){
                    wCount++;
                }else{
                    bCount++;
                }
                
                if(grid[i-1][j] == 'W'){
                    wCount++;
                }else{
                    bCount++;
                }
                if(grid[i][j-1] == 'W'){
                    wCount++;
                }else{
                    bCount++;
                }
                if(grid[i-1][j-1] == 'W'){
                    wCount++;
                }else{
                    bCount++;
                }
                
                if( bCount == 1 || wCount == 1 || wCount == 4 || bCount == 4){
                    return true;
                }
            }
        }
        
        return false;
    }
}