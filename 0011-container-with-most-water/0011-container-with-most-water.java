class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int max = area;
        
        if(height.length < 2) return max;
        if(height.length == 2) return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length-1;
        int width = (right-left);
        
        while(left < right){
            if(height[left] < height[right]){
                area = height[left] * width;
                left++;
                width--;
            }else if(height[left] > height[right]){
                area = height[right] * width;
                right--;
                width--;
            }else{
                area = height[right] * width;
                left++;
                right--;
                width-=2;
            }
            if(area > max){
                max = area;               
            }
        }
        
        return max;
        
    }
}