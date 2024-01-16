class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;

        while(left <= right){
            int mid = left + (right-left)/2;
   
            int midval = matrix[mid/n][mid%n];

            if(midval == target) return true;
            else if(midval > target){
                right = mid-1;
            }
            else left = mid+1;
        }

        return false;
        
    }
}