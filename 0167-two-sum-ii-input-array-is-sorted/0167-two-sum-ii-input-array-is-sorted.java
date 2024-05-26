class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // sorted array - binary search - O(nlogn) or 2 pointer - O(n)
        int f = 0;
        int l = numbers.length-1;
        int[] ans = new int[2];
        while(f < l){
            if(numbers[f] + numbers[l] > target){
                l--;
            }else if (numbers[f] + numbers[l] < target){
                f++;
            }else{
                ans[0] = f+1;
                ans[1] = l+1;
                break;
            }
        }
        return ans;
    }
    
    
}