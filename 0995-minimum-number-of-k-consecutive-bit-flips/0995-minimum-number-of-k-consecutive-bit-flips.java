class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // optmized approach (of prev sol) by neetcode 
        int curr_wind_count = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i >= k && nums[i-k] == 2){
                curr_wind_count--;
            }

            if((nums[i] + curr_wind_count)%2 == 0){
                if(i+k > nums.length){
                    return -1;
                }
                nums[i] = 2;
                count++;
                curr_wind_count++;
            }
        }
        
        return count;
        // approach by neetcode
        /*int count = 0;
        Deque<Integer> q = new LinkedList<Integer>(); // stores indexes of flipped
        int i = 0;
        while(i < nums.length){
            // if queue has old/irrelevant indexes remove
            while(!q.isEmpty() && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }
            
            // there is 0 in the hypothetical array - flip k elements
            if((nums[i] + q.size()) % 2 == 0){//anotherway if((totalFlips & 1) == nums[i]){
                // have to flip, but there are less than k elements // can't flip
                if(i + k > nums.length){
                    return -1;
                }
                count++;
                q.offer(i);
            }
            i++;
        }
        return count;*/
        
        
        // apporach without actually flipping
        // too many edge cases
        /*int count = 0;
        int s = 0;
        int bit = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == bit){  // 3, 0000110 | 3, 000011 | 3, 0000111
                int j = i;
                count++;
                while(j < i + k){
                    if(j < nums.length && nums[j] == bit){
                        j++;
                    }else{
                        bit = 1-bit;
                        break;
                    }
                }
                if(j == nums.length) 
                    return count;
                if(j < i + k){
                    bit = 0;
                }
                i = j;
            }else{
                i++;
            }
        }
        // check for -1
        return count;*/
    } 

        // apporach - flipping k from every 0 and continue from first 1
        // gives TLE for last 10 big inputs
    /*
    public int minKBitFlips(int[] nums, int k) {   
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < nums.length - k + 1){
                if(nums[i] == 0){
                    i = flip(nums, i, k) - 1;
                    count++;
                }
            }else{
                if(nums[i] == 0) return -1;
            }
        }
        return count;
    }
    
    private int flip(int[] nums, int i, int k){
        int flag = -1;
        for(int j = i; j < i+k; j++){
            if(nums[j] == 1 && flag == -1){
                flag = j;
            }
            nums[j] = 1-nums[j];
        }    
        if(flag == -1)
            return i+k;
        return flag;
    }*/
    
     // basic apporach - flipping k from every 0
    // gives TLE for last 2 big inputs
     /*  public int minKBitFlips(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < nums.length - k + 1){
                if(nums[i] == 0){
                    flip(nums, i, k);
                    count++;
                }
            }else{
                if(nums[i] == 0) return -1;
            }
        }
        return count;
    }
    
    private void flip(int[] nums, int i, int k){
        for(int j = i; j < i+k; j++){
            nums[j] = 1-nums[j];
        }    
    } */
}