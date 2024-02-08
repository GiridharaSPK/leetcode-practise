class Solution {
    public int numSquares(int n) {
        // memoization
        /** 
        if(cache.containsKey(n)) return cache.get(n);
        System.out.println("n = " + n);
        if(isPerfectSq(n, cache)) return 1;
        int leastCount = n;
        int k = 1;
        while(k*k < n){
            System.out.println("k = " + k);
            int temp = numSquares(n - (k*k)) + 1;
            System.out.println("numSq = " + temp);
            if(leastCount+1 > temp)
                leastCount = temp;
            k++;
        }
        cache.put(n, leastCount);
        return leastCount;*/
        
        //dp

        int[] ar = new int[n+1];
        // ar[0] = 0;
        // ar[1] = 1;
        // ar[2] = 2;
        // ar[3] = 3;
        int k = 0;
        while(k < n+1){
            ar[k] = k;
            k++;
        }

        for(int i = 4; i <= n; i++){
            for(int j = 2; j*j <= i; j++){
                ar[i] = Math.min(ar[i], ar[i-(j*j)] + 1);
                // System.out.println("ar["+i+"]"+ ar[i]);
            }
        }
        return ar[n];
    }

    boolean isPerfectSq(int n, HashMap<Integer, Integer> cache){
        double sqrt=Math.sqrt(n);   
        boolean flag = (sqrt == Math.floor(sqrt)); 
        if(flag) cache.put(n, 1);
        return flag;
    }
}