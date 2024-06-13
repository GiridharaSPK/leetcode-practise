class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        // approach 1
        // doing in O(1) space 
        // using first row and first col as flags
        
        /*var frow = false // flag to mark if the 1st row originally have 0s
        var fcol = false // flag to mark if the 1st col originally have 0s
        for(i in 0 until matrix.size){
            for(j in 0 until matrix[0].size){
                if(matrix[i][j] == 0){
                    if(i == 0) frow = true
                    if(j == 0) fcol = true
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(i in 0 until matrix.size){
                matrix[i][0] = 0
            }
        }
        
        for(i in 1 until matrix.size){
            for(j in 1 until matrix[0].size){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0
                }
            }
        }
        
        if(frow){
            for(i in 0 until matrix[0].size){
                matrix[0][i] = 0
            }
        }
        
        if(fcol){
            for(i in 0 until matrix.size){
                matrix[i][0] = 0
            }
        }*/
        
        // approach 2 (extension of approach 1) with single flag
        // doing in O(1) space 
        
        var frow = false // flag to mark if the 1st row originally have 0s
        for(i in 0 until matrix.size){
            for(j in 0 until matrix[0].size){
                if(matrix[i][j] == 0){
                    if(i == 0) 
                        frow = true 
                    else // not marking matrix[0][0] = 0 for first row
                        matrix[i][0] = 0
                    
                    matrix[0][j] = 0
                }
            }
        }

        for(i in 1 until matrix.size){
            for(j in 1 until matrix[0].size){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(i in 0 until matrix.size){
                matrix[i][0] = 0
            }
        }
        
        if(frow){
            for(i in 0 until matrix[0].size){
                matrix[0][i] = 0
            }
        }
        
        
        /* O(n) space approach
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
        */
    }
}