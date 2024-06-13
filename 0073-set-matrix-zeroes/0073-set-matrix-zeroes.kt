class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = HashSet<Int>();
        val cols = HashSet<Int>();
        
        for(i in 0 until matrix.size){
            for(j in 0 until matrix[0].size){
                if(matrix[i][j] == 0){
                    rows.add(i)
                    cols.add(j)
                }
            }
        }
        
        for(i in rows){
            // coloring the entire row
            for(j in 0 until matrix[0].size){
                matrix[i][j] = 0
            }
        }
        for(i in cols){
            // coloring the entire col
            for(j in 0 until matrix.size){
                matrix[j][i] = 0
            }
        }
        
    }
}