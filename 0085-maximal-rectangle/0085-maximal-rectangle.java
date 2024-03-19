class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] input = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(i == 0) input[i][j] = (matrix[i][j] == '0')?0:1;
               else{
                   if(matrix[i][j] == '0') input[i][j] = 0;
                   else input[i][j] = input[i-1][j] + 1;
                }
            }
        }
        
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(input[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int maxArea = 0;
        for(int i=0; i<m; i++){
            maxArea = Math.max(maxArea, calculateMaxArea(input[i]));
        }
        
        return maxArea;
    }
    
    public int calculateMaxArea(int[] heights){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0, n = heights.length;
        
        for(int i=0; i<=n; i++){
            int currHeight = ((i == n)?0:heights[i]);
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int minHeight = heights[stack.pop()];
                int area = (i - (stack.isEmpty()?0:stack.peek() + 1))*minHeight;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}

/*

1 0 1 0 0
2 0 2 1 1
3 1 3 2 2
4 0 0 3 0


0 0 0 0 0   
0 0 2 4 2 
0 0 1 1 1 
1 0 0 1 0 



*/