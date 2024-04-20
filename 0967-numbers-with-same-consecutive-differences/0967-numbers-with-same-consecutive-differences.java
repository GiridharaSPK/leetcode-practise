class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        // dfs
        /*HashSet<Integer> set = new HashSet<>();

        for(int d = 1; d < 10; d++) { // adding from 0 may cause stackoverflow
            dfs(n-1, k, d, set);
        }

        int[] ans = new int[set.size()];
        int j=0;
        for(Integer i : set){
            ans[j] = i;
            j++;
        }
        return ans;*/
        
        
        //bfs
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int d=1;d<10;d++){
            //adding from 0 may cause stackoverflow, anyway we dont start with 0
            q.add(d); 
        }
        bfs(n, k, q);
        int[] ans = new int[q.size()];
        int j = 0;
        for(Integer i : q){
            ans[j] = i;
            j++;
        }
        return ans;
    }
    
    private void bfs(int n, int k, Queue<Integer> q){
        int level = 1;
        int size = q.size();
        while(!q.isEmpty() && level < n){
            level++;
            size = q.size();
            for(int i = 0; i < size; i++){
                int num = q.remove();
                int d = num%10;
                if(d + k <= 9) 
                    q.add(num*10 + d+k);
                if(k!=0 && d - k >= 0) 
                    q.add(num*10 + d-k);
            }
        }
    }
    
    /*private void bfs(int n, int k, Queue<Integer> q){
        while(!q.isEmpty()){
            int num = q.peek();
                if(num >= Math.pow(10, n-1) && num < Math.pow(10,n)) return;
            q.remove();
            
            int d = num%10;
            if(d + k <= 9) 
                q.add(num*10 + d+k);
            if(k!=0 && d - k >= 0) 
                q.add(num*10 + d-k);
        }
    }*/
    
    private void dfs(int n, int k, int num, HashSet<Integer> set){
        if(n == 0) {
            set.add(num);
            return;
        }
        int d = num % 10;
        if(d + k <= 9) 
            dfs(n-1, k, num*10+(d+k), set); // adding 0 to init list could cause stackoverflow
        // as d+k and further nums keep becoming 0 
        if(k!=0 && d - k >= 0) dfs(n-1, k, num*10+(d-k), set);
    }
    
}