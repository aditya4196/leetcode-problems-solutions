class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] prev = new int[rowIndex+1];
        int[] curr = new int[rowIndex+1];
        
        for(int i=0; i<=rowIndex; i++){
            curr = new int[rowIndex+1];
            curr[0] = curr[i] = 1;
            for(int j=1; j<i; j++){
                curr[j] = prev[j-1] + prev[j];
            }
            prev = curr;
        }
        
        return Arrays.stream(curr).boxed().toList();
        
        
        
        
    }
}

/*

0 - 1
1 - 1 1        
2 - 1 2 1
3 - 1 3 3 1
4 - 1 4 6 4 1
5 - 1 5 10 10 5 1
   [1 2 1 0 0 0 0]  
   [1 3 3 1 0 0 0] 


*/