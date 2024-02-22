class Solution {
    public int findJudge(int n, int[][] trust) {

        if(trust.length < (n-1)) return -1;
        
        int[] trustscores = new int[n+1];
        
        for(int i=0; i<trust.length; i++){
            int[] pair = trust[i];
            trustscores[pair[0]]--;
            trustscores[pair[1]]++;
        }
        
        for(int i=1; i<=n; i++){
            if(trustscores[i] == (n-1)) return i;
         }
        return -1;
        
    }
}

/*

[1,3][2,3][3,1]


boolean[] 
cand = 3


*/