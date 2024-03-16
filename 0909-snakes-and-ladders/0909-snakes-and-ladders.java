class Solution {
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n*n+1];
        
        Integer[] columns = new Integer[n];
        for(int i=0; i<n; i++) columns[i] = i;
        
        int index = 1;
        for(int i=n-1; i>=0; i--){
            for(int col : columns){
                cells[index++] = new Pair<Integer, Integer>(i, col);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        
        int[] dist = new int[n*n+1];
        Arrays.fill(dist, -1);
        bfs(board, cells, 1, dist);
        
        return (dist[n*n] == Integer.MAX_VALUE)?-1:dist[n*n];
    }
    
    public void bfs(int[][] board, Pair<Integer, Integer>[] cells, int idx, int[] dist){
        Deque<Integer> queue = new ArrayDeque();
        int n = board.length;
        queue.offer(idx);
        dist[1] = 0;
        
        while(queue.size() > 0){
            int curr = queue.poll();
            for(int i=curr+1; i<=Math.min(n*n, curr+6); i++){
                int nextrow = cells[i].getKey();
                int nextcol = cells[i].getValue();

                int dest = (board[nextrow][nextcol] == -1)?i:board[nextrow][nextcol];

                if(dist[dest]  == -1){
                    dist[dest] = dist[curr] + 1;
                    queue.offer(dest);
                }
            }
            
        }

    }
}