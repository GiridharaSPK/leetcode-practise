class Solution {
    fun numSquares(n: Int): Int {
        val ar = IntArray(n+1) { i -> i };

        for(i in 4..n){
            var j = 0;
            while(j*j <= i){
                ar[i] = Math.min(ar[i], ar[i-(j*j)]+1);
                // println(ar.joinToString())
                j++;
            }
        }
        return ar[n];
    }
}