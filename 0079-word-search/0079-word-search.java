class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length, n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                if(board[i][j] == word.charAt(0) && helper(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, String word, int idx, boolean[][] visited){
        if(!isValidBounds(i, j, board.length, board[0].length) || visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length()-1 && board[i][j] == word.charAt(idx)) return true;
        
        boolean wordExists = false;
        visited[i][j] = true;
        
        wordExists = helper(board, i-1, j, word, idx+1, visited)
            || helper(board, i+1, j, word, idx+1, visited)
            || helper(board, i, j-1, word, idx+1, visited)
            || helper(board, i, j+1, word, idx+1, visited);
        visited[i][j] = false;
        return wordExists;
    }
    
    public boolean isValidBounds(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}