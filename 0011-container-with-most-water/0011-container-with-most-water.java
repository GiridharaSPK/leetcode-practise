class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length-1;
        int area = 0;
        int max = area;
        
        while(left < right){
            area = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(area, max);
            
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        
        return max;
        
    }
}