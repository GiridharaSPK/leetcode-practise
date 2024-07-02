class Solution {
    fun maxHeightOfTriangle(red: Int, blue: Int): Int {
        return Math.max(helper(red, blue, false, 1), helper(red, blue, true, 1))
    }
    
    private fun helper(red: Int, blue: Int, isBlue: Boolean, level: Int): Int{
        if(isBlue){
            if(blue < level) return 0
            return 1 + helper(red, blue-level, false, level+1)
        }else{
            if(red < level) return 0
            return 1 + helper(red-level, blue, true, level+1)
        }
    }
}