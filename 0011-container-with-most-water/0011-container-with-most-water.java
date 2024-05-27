class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        
        int area = 0;
        int max = area;
        
        while(left < right){
            if(height[left] < height[right]){
                area = height[left] * (right-left);
                left++;
            }else if(height[left] > height[right]){
                area = height[right] * (right-left);
                right--;
            }else{
                area = height[right] * (right-left);
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