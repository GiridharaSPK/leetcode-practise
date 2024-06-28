class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var n = matrix[0].size // columns
        var m = matrix.size // rows
        val list = ArrayList<Int>()
        
        var cmin = 0
        var rmin = 0
        var cmax = n-1 
        var rmax = m-1
        
        var r = rmin
        var c = cmin
        while(cmin <= cmax && rmin <= rmax){
            r = rmin 
            c = cmin
            while(r in (rmin..rmax) && c <= cmax){
                list.add(matrix[r][c])
                c++
            }
            c--
            r++
            rmin++
            
            // last column - downwards
            while(c in (cmin..cmax) && r <= rmax){
                list.add(matrix[r][c])
                r++
            }
            r--
            c--
            cmax--
            
            // last row - left wards
            while(r in (rmin..rmax) && c >= cmin){
                list.add(matrix[r][c])
                c--
            }
            c++
            r--
            rmax--
            
            // first column and last row - upwards
            while(c in (cmin..cmax) && r >= rmin){
                list.add(matrix[r][c])
                r--
            }
            r++
            cmin++
        }
        return list
    }
}