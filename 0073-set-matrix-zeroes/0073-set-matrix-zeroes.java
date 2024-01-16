public class Solution {
    public void fillRowsLeft(int[][] matrix, int i, int j) {
        while (i >= 0) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 100001;
            }
            i--;
        }
    }

    public void fillRowsRight(int[][] matrix, int i, int j) {
        while (i < matrix.length) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 100001;
            }
            i++;
        }
    }

    public void fillColumnUp(int[][] matrix, int i, int j) {
        while (j >= 0) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 100001;
            }
            j--;
        }
    }

    public void fillColumnDown(int[][] matrix, int i, int j) {
        while (j < matrix[0].length) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 100001;
            }
            j++;
        }
    }

    public void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        fillColumnDown(matrix, i, j);
        fillColumnUp(matrix, i, j);
        fillRowsLeft(matrix, i, j);
        fillRowsRight(matrix, i, j);
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    dfs(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 100001) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
