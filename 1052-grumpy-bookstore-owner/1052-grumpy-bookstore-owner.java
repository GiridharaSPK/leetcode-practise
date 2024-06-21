class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // without secret
        int happy = 0;
        // int unhappy = 0;
        
        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0){
                happy += customers[i];
            // }else{
                // unhappy += customers[i];
            }
        }
        int l = 0;
        int r = 0;
        int max = happy;
        /*while(r <= l + minutes - 1){
            if(grumpy[r] == 1){
                happy += customers[r];
                if(happy > max) max = happy;
            }
            r++;
        }
        // r > l + minutes - 1
        while(r < customers.length){
            if(grumpy[l] == 1){
                happy -= customers[l];
            }
            l++;            
            if(grumpy[r] == 1){
                happy += customers[r];
            }
            r++;
            if(happy > max) 
                max = happy;
        }*/
        
        while(r < customers.length){
            if(grumpy[r] == 1){
                happy += customers[r];
            }
            if(r - l + 1 > minutes){ 
                if(grumpy[l] == 1){
                    happy -= customers[l];
                }
                l++;
            }
            r++;
            if(happy > max) 
                max = happy;
        }
        return max;
    }
}