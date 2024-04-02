class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack();
        int[] ans = new int[nums1.length];
        int[] temp = new int[nums2.length];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1; i>=0; i--){
            map.put(nums2[i],i);
            
            while(!s.isEmpty() && s.peek() < nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                temp[i] = -1;
            }else{
                temp[i] = s.peek();
            }
            
            s.push(nums2[i]);
            
        }
        
        for(int i = 0; i < nums1.length; i++){
            ans[i] = temp[map.get(nums1[i])];
        }
        return ans;  
    }
}