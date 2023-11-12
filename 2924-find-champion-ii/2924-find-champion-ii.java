class Solution {
    public int findChampion(int n, int[][] edges) {
        
        boolean[] isWeak = new boolean[n];
        
        for(int[] edge : edges){
            isWeak[edge[1]] = true;
        }
        
        int count = 0;
        int winner = -1;
        for(int i=0; i<n; i++){
            if(!isWeak[i]){
                winner = i;
                count++;
            }
        }
        return (count == 1)?winner:-1;
    }
}