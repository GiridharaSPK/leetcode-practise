class Solution {
    public void rotate(int[][] matrix) {
        helper(0, matrix.length-1, matrix);
    }
    
    private void helper(int start, int end, int[][] matrix){
        if(start > end) return;
        int n = end - start;
        while(n > 0){
            n--;
            swapOnce(start, end, matrix);
        }
        helper(start+1, end-1, matrix);
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