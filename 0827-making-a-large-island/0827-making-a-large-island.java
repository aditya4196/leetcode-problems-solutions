class Solution {
    
    private int maxArea;
    
    private int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int largestIsland(int[][] grid) {
        
        initMaxArea();
        Map<Integer, Integer> islandMap = new HashMap();
        int m = grid.length, n = grid[0].length;

        int[][] components = new int[m][n];
        
        int islandId = 2;
        boolean hasZero = false;
        
        
        //dfs to get islands
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && components[i][j] == 0){
                    setMaxArea(dfs(grid, i, j, islandId, components));
                    islandMap.put(islandId, getMaxArea());
                    initMaxArea();
                    islandId++;
                }
                else if(grid[i][j] == 0) hasZero = true;
            }
        }
        
        if(!hasZero) return m*n;
        
        int largeArea = 0;
        
        //go through zeros and combine the islands
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};


        
        Set<Integer> addedIsland = new HashSet();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                addedIsland = new HashSet();
                int addedArea = 1;
                if(components[i][j] == 0){
                    for(int[] dir : dirs){
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        if(isBoundaryValid(ni, nj, m, n) && components[ni][nj] != 0 && !addedIsland.contains(components[ni][nj])){
                            addedArea += islandMap.get(components[ni][nj]);
                            addedIsland.add(components[ni][nj]);
                        }
                    }
                    largeArea = Math.max(largeArea, addedArea);
                }
            }
        }
        
        return largeArea;
    }
    
    public int dfs(int[][] grid, int i, int j, int isid, int[][] components){
        if(!isBoundaryValid(i,j,grid.length, grid[0].length) || grid[i][j] == 0 || components[i][j] != 0) return 0;
        
        components[i][j] = isid;
        
        int count = 1;
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            count += dfs(grid, ni, nj, isid, components);
        }
        
        return count;
    }
    
    public boolean isBoundaryValid(int i, int j, int m, int n){
        return (i>=0 && j>=0 && i<m && j<n);
    }
    
    
    
    public void initMaxArea(){
        maxArea = 0;
    }
    
    public void setMaxArea(int newArea){
        maxArea = Math.max(maxArea, newArea);
    }
    
    public int getMaxArea(){
        return maxArea;
    }

}