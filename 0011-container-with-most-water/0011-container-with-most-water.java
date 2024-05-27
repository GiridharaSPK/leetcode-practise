class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        
        int area = 0;
        int max = area;
        
        while(left < right){
            int width = (right-left);
            if(height[left] < height[right]){
                area = height[left] * width;
                left++;
            }else if(height[left] > height[right]){
                area = height[right] * width;
                right--;
            }else{
                area = height[right] * width;
                left++;
                right--;
            }
            if(area > max){
                max = area;               
            }
        }
        
        return max;
        
    }
}