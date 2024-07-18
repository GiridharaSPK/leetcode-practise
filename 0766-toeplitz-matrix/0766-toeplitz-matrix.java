class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int rowStart = 0;
        int colStart = cols-1;
        while(colStart > 0){
            int row = rowStart;
            int col = colStart;
            int num = matrix[row][col];
            while(row+1 < rows && col+1 < cols){
                row++;
                col++;
                if(matrix[row][col] != num){
                    return false;
                }
            }
            colStart--;
        }
        
        while(rowStart < rows){
            int row = rowStart;
            int col = 0;
            int num = matrix[row][col];
            while(row+1 < rows && col+1 < cols){
                row++;
                col++;
                if(matrix[row][col] != num){
                    return false;
                }
            }
            rowStart++;
        }
        
        return true;
    }
}