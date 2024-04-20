class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int d = 1; d < 10; d++) { // adding from 0 may cause stackoverflow
            dfs(n, k, d, set);
        }
        
        int[] ans = new int[set.size()];
        int j=0;
        for(Integer i : set){
            ans[j] = i;
            j++;
        }
        return ans;
    }
    
    private void dfs(int n, int k, int num, HashSet<Integer> set){
        if(num >= Math.pow(10,n-1) && num < Math.pow(10,(n))) {
            set.add(num);
            return;
        }
        int d = num % 10;
        if(d + k <= 9) dfs(n, k, num*10+(d+k), set); // adding 0 to init list could cause stackoverflow
        // as d+k and further nums keep becoming 0 
        if(k!=0 && d - k >= 0) dfs(n, k, num*10+(d-k), set);
    }
    
}