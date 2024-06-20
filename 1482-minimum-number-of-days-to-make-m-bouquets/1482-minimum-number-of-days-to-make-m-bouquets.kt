class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        val n = bloomDay.size.toLong()
        if(n < m.toLong() * k) return -1
        
        val max = bloomDay.max()
        val min = bloomDay.min()
        
        var day = min
        var l = min
        var r = max
        var ans = max
        while(l <= r){
            val mid = l + (r-l)/2
            val temp = countPossibleBouqets(bloomDay, k, mid)
            if(temp == m){
                r = mid-1
                ans = mid
            }else if(temp > m){
                r = mid-1
            }else {
                l = mid+1
            }
        }
        return ans
    }
    
    private fun countPossibleBouqets(bloomDay: IntArray, k: Int, day: Int) : Int{ 
        var c = 0 // num of bouqets
        var f = 0 // num of blossomed flowers
        for(i in bloomDay){
            if(i <= day){
                f++
            }else{
                c += f/k
                f = 0
            }
        }
        c += f/k
        
        return c
    }
}