class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red, blue, 1, true), helper(red, blue, 1, false));
    }
    
    private int helper(int red, int blue, int current, boolean isRed){
        if(isRed){
            if(red < current) return 0;
            return 1 + helper(red - current, blue, current+1, !isRed);
        }else{
            if(blue < current) return 0;
            return 1 + helper(red, blue - current, current+1, !isRed);
        }
    }
}