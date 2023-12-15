class Solution {
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        return backtrack(0, new HashSet<Integer>(),new HashSet<Integer>(),new HashSet<Integer>(), board);  
    }
    
    public int backtrack(int row, HashSet<Integer> colset, HashSet<Integer> leftset, HashSet<Integer> rightset, char[][] board){
        if(row == n) return 1;
        
        int result = 0;
        for(int col=0; col<n; col++){
            int left = row-col;
            int right = row+col;
            
            if(colset.contains(col) || leftset.contains(left) || rightset.contains(right)) continue;
            
            colset.add(col);
            leftset.add(left);
            rightset.add(right);
            board[row][col] = 'Q';
            result += backtrack(row+1, colset, leftset, rightset, board);
            colset.remove(col);
            leftset.remove(left);
            rightset.remove(right);
            board[row][col] = '.';
            
        }
        
        return result;
        
        
    }
}