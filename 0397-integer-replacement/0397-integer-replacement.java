class Solution {
    public int integerReplacement(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return helper(map, n);
    }
    
    private int helper(HashMap<Integer, Integer> map, int n){     
        if(n == 1) return 0;
        
        if(n == Integer.MAX_VALUE) return 32;
        
        if(map.containsKey(n)) return map.get(n);
        
        int temp = -1;
        if(n%2 == 0){
            temp = 1 + integerReplacement(n/2);
        }else{
            temp = 1 + Math.min(integerReplacement(n+1), integerReplacement(n-1));
        }
        
        map.put(n, temp);
        return temp;
    }
}