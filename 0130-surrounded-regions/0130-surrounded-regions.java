class Solution {
    public void solve(char[][] board) {
        
        //set land boundaries as 'E'
        for(int i=0; i<board.length; i++){
            dfs(board, i, 0, true);
            dfs(board, i, board[0].length-1, true);
        }
        
        for(int i=0; i<board[0].length; i++){
            dfs(board, 0, i, true);
            dfs(board, board.length-1, i, true);
        }
        

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'O'){
                    dfs(board, i, j, false);
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'E') board[i][j] = 'O';
            }
        }
        
        
        
        

        
        
        
    }
    
    public void dfs(char[][] board, int i, int j, boolean isBoundary){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = (isBoundary)?'E':'X';
        
        dfs(board, i-1, j, isBoundary);
        dfs(board, i+1, j, isBoundary);
        dfs(board, i, j-1, isBoundary);
        dfs(board, i, j+1, isBoundary);
    
    }
}