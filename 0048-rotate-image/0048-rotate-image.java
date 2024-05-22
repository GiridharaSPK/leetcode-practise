class Solution {
    public void rotate(int[][] matrix) {
        
        // approach2: transpose and swap
        convertRowsToCols(matrix);
        swapCols(matrix); //0,n .. 1,n-1 .. 
        
        // approach1: rotate n-1 times each edge recursively
        // swapHelper(0, matrix.length-1, matrix);
    }
    
    private void convertRowsToCols(int[][] matrix){
        for(int r = 0; r < matrix.length; r++){
            for(int c = r+1; c < matrix[0].length; c++){
                swap(matrix, r, c, c, r);
            }
        }
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
    
    private void swapCols(int[][] matrix){
        int n = matrix.length;
        for(int r = 0; r < n; r++){
            for(int c = n/2; c < n; c++){
                swap(matrix, r, c, r, n-c-1);
            }
        }
    }

    // approach 1
    private void swapHelper(int start, int end, int[][] matrix){
        if(start > end) return;
        int n = end - start;
        while(n > 0){
            n--;
            swapOnce(start, end, matrix);
        }
        swapHelper(start+1, end-1, matrix);
    }
    
    private void swapOnce(int start, int end, int[][] matrix){
        int n = end-start+1;
        // swap first row
        int temp = matrix[start][end];
        for(int i = end;i > start; i--){
            matrix[start][i] = matrix[start][i-1];
        }
        
        // swap last column
        int temp2 = matrix[end][end];
        for(int i = end; i > start; i--){
            matrix[i][end] = matrix[i-1][end];
        }
        matrix[start+1][end] = temp;

        // swap last row
        int temp3 = matrix[end][start];
        for(int i = start; i < end; i++){
            matrix[end][i] = matrix[end][i+1];
        }
        matrix[end][end-1] = temp2;
        
        // swap first column
        for(int i = start; i < end; i++){
            matrix[i][start]=matrix[i+1][start];
        }
        matrix[end-1][start]=temp3;
    }
    
}