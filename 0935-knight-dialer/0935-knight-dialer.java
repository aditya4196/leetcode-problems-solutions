class Solution {
    
    List<Integer>[] adjlist;
    int mod = 1000000007;
    public int knightDialer(int n) {
        
        if(n == 1) return 10;
        
        adjlist = new ArrayList[10];
        for(int i=0; i<=9; i++) adjlist[i] = new ArrayList<Integer>();
        
        adjlist[0].addAll(Arrays.asList(4,6));
        adjlist[1].addAll(Arrays.asList(6,8));
        adjlist[2].addAll(Arrays.asList(7,9));
        adjlist[3].addAll(Arrays.asList(4,8));
        adjlist[4].addAll(Arrays.asList(0,3,7));
        adjlist[6].addAll(Arrays.asList(0,1,7));
        adjlist[7].addAll(Arrays.asList(2,6));
        adjlist[8].addAll(Arrays.asList(1,3));  
        adjlist[9].addAll(Arrays.asList(2,4));
        
        int result = 0;
        
        for(int i=0; i<=9; i++){
            result = (result + helper(n-1, i, new Integer[n][10])) % mod; 
        }
        
        return result;      
    }
    
    public int helper(int remain, int curr, Integer[][] dp){
        if(remain == 0) return 1;
        
        if(dp[remain][curr] != null) return dp[remain][curr];
        
        int ways = 0;
        for(int next : adjlist[curr]){
            ways = (ways + helper(remain - 1, next, dp)) % mod;
        }
        
        return dp[remain][curr] = ways;
        
    }
}

/*

 1 2 3
 4 5 6
 7 8 9
-1 0 -1

 0 1 2 3 4 5 6 7 8 9
[2 2 2 2 3 2 3 2 2 2]


bfs -> 
n = 3

bfs run for n-1 times
0 = 3 + 3 -> 8
1 = 3 + 2 -> 7
2 = 4
3 = 5
4 = 6
6 = 6
7 = 5
8 = 4
9 = 5





0 -> 4,6
1 -> 

[]









*/