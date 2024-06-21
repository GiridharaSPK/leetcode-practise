class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        // elements are not in an order or consecutive
        // brute force - recursion / dp approach to place balls
        // min force between any two balls is maximum 
        // if all the adjacent widths are equal
        // have to try with a width between balls ranging from 1 to max(pos) - min(pos)
        // balls seperated with width 1 (or more) -> 2 (or more) -> ...
        // or more because we cant guarantee existance of a position in the array
        
        // doing binary search by sorting the array
        Arrays.sort(position);
        val n = position.size
        var start = 1
        var end = position[n-1] - position[0]
        var ans = end;
        while(start <= end){
            val mid = start + (end - start)/2
            if(isPossible(mid, position, m)){
                ans = mid
                // increase width to increase force
                start = mid+1
            }else{
                end = mid-1
            }
        }
        return ans
    }
    
    // checking if m balls can be placed at w distance seperated
    private fun isPossible(w : Int, position : IntArray, m : Int): Boolean {
        var recentPos = position[0] //first ball placed at min position
        var numOfBalls = m-1 
        for(pos in position){
            // because we cant gurantee presence of recentPos + w in array
            if(pos - recentPos >= w){ 
                // place next ball
                numOfBalls--
                recentPos = pos
            }
            if(numOfBalls == 0) return true
        }
        
        // return true of all balls are placed
        return numOfBalls == 0
        
    }
    
}