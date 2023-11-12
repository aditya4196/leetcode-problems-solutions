class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        backtrack(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    public void backtrack(int[][] image, int i, int j, int oldcolor, int newcolor){
        if(i < 0 || j < 0 || i > image.length-1 || j > image[0].length-1 || image[i][j] == newcolor || image[i][j] != oldcolor) return;
        image[i][j] = newcolor;
        
        backtrack(image, i-1, j, oldcolor, newcolor);
        backtrack(image, i+1, j, oldcolor, newcolor);
        backtrack(image, i, j-1, oldcolor, newcolor);
        backtrack(image, i, j+1, oldcolor, newcolor);
    }
}