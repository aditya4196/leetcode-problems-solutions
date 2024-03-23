class TicTacToe {
    int[][] rowscore;
    int[][] colscore;
    int[] leftdiagscore;
    int[] rightdiagscore;
    int n;
    public TicTacToe(int n) {
        rowscore = new int[n][2];
        colscore = new int[n][2];
        leftdiagscore = new int[2];
        rightdiagscore = new int[2];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        setScore(row, col, player, this.n);
        return getWinner(row, col, player); 
    }
    
    public void setScore(int row, int col, int player, int n){
            if(row == col){
                leftdiagscore[player-1] += 1;
            }
            if(row == (n-col-1) || (col == (n-row-1))){
                rightdiagscore[player-1] += 1;
            } 
            rowscore[row][player-1] += 1;
            colscore[col][player-1] += 1;
            
        
    }
    
    public int getWinner(int row, int col, int player){
        if(leftdiagscore[player-1] == this.n || rightdiagscore[player-1] == this.n) return player;
        else if(rowscore[row][player-1] == this.n || colscore[col][player-1] == this.n) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

/*
  0. 1
0[*, 0], 
1[0, X], 

row[0]
row[1]
row[2]


*/