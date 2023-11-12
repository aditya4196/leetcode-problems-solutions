class Solution {
    public int findChampion(int[][] grid) {
        boolean[] isWeak = new boolean[grid.length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i == j) continue;
                if(grid[i][j] == 1) isWeak[j] = true;
                else isWeak[i] = true;
            }
        }

        for(int i=0;i<grid.length; i++){
            if(!isWeak[i]) return i;
        }
        
        return -1;
        
        
    }
}