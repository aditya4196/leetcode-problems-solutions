class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        int[] prefixSum = new int[n];
        
        prefixSum[0] = (s.charAt(0) == '*')?1:0;
        rightMost[0] = 0;
        leftMost[n-1] = n-1;
        
        for(int i=1; i<n; i++){
            int j = n-i-1;
            
            if(s.charAt(i) == '|') rightMost[i] = i;
            else rightMost[i] = rightMost[i-1];
            
            if(s.charAt(j) == '|') leftMost[j] = j;
            else leftMost[j] = leftMost[j+1];
        }
        
        //prefixSum
        
        for(int i=1; i<n; i++){
            if(s.charAt(i) == '*') prefixSum[i] = prefixSum[i-1]+1;
            else prefixSum[i] = prefixSum[i-1];
        }
        
        
        
        int[] result = new int[queries.length];
        int i =0;
        
        for(int[] query : queries){
            int a = query[0];
            int b = query[1];
            
            int leftIdx = leftMost[a];
            int rightIdx = rightMost[b];

            int count = prefixSum[rightIdx] - prefixSum[leftIdx];
            result[i++] = (count < 0)?0:count;
        }
        return result;
        
        
    }
}

/*


"***|**|*****|**||**|*"
[[1,17],[4,5],[14,17],[5,11],[15,16]]


1223445677

0022255559
2225559999

0123456789




leftHold
0 - 5
1 - 5
4 - 3
5 - 3
8 - 1

RightHold
0 - 0
1 - 0
4 - 2
5 - 2
8 - 4



[[2,5],[5,9]]




[1,4] = 2
[5.8] = 2








*/