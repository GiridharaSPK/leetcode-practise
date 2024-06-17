class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i: power){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> uniquePowers = new ArrayList<>(freq.keySet());
        Collections.sort(uniquePowers);
        int n = uniquePowers.size();

        long[] dp = new long[n];
        int p = uniquePowers.get(0); // smallest power
        dp[0] = (long) freq.getOrDefault(p, 0) * p;
        
        for(int i = 1; i < n; i++){
            // calculating the sum with only this element
            int e = uniquePowers.get(i);
            long curr = (long) freq.getOrDefault(e, 0) * e; 
            
            long maxSum = curr;
            
            // in the sorted array of uniquePowers
            // the prev 2 could be (could not be) power-1 or power-2 
            // so getting the max of them
            
            // ignoring current element and going with i-1 element
            if(i-1 >= 0 && maxSum < dp[i-1] && (uniquePowers.get(i-1) == e - 1|| uniquePowers.get(i-1) == e - 2)){ 
                maxSum = dp[i-1]; 
            }
            // ignoring current and prev and going with i-2 element
            if(i-2 >= 0 && maxSum < dp[i-2] && uniquePowers.get(i-2) == e - 2){ 
                maxSum = dp[i-2];
            }
            
            // finding a power smaller than power-2 and it adding current sum
            // i.e. including current and a (first) power smaller than power-2 
            int j = i;
            while(j >= 0 && uniquePowers.get(j) >= uniquePowers.get(i)-2){
                j--;
            }
            if(j >=0 && maxSum < dp[j] + curr){
                maxSum = dp[j] + curr;
            }
            dp[i] = maxSum;
            
        }
        
        return dp[n-1];
        
        // recursion // giving TLE
        /*long[] maxSum = new long[1];
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();   
        helper(power, maxSum, 0, 0, visited);
        return maxSum[0];*/
    }
    
    private void helper(int[] power, long[] maxSum, int i, long currSum, HashMap<Integer, Integer> visited){
        if(maxSum[0] < currSum){
            maxSum[0] = currSum;
        }
        if(i >= power.length) return;
                
        if(!visited.containsKey(power[i]+1) && !visited.containsKey(power[i]-1) 
           && !visited.containsKey(power[i]+2) && !visited.containsKey(power[i]-2)){
            visited.put(power[i], visited.getOrDefault(power[i], 0) + 1);
            helper(power, maxSum, i+1, currSum + power[i], visited);
            // remove
            if(visited.get(power[i]) > 1) {
                visited.put(power[i], visited.get(power[i]) - 1);
            }else{
                visited.remove(power[i]);
            }
        }
        helper(power, maxSum, i+1, currSum, visited);
        
    }
}