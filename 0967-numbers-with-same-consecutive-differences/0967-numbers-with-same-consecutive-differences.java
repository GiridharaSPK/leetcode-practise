class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        // BFS
        // Queue<Integer> q = new LinkedList<Integer>();
        // for(int i = 1; i < 10; i++){
        //     q.offer(i);
        // }
        // bfs(n, k, q);
        // int[] ans = new int[q.size()];
        // int i = 0;
        // while(!q.isEmpty()){
        //     ans[i] = q.poll();
        //     i++;
        // }
        // return ans;
        
        // DFS
        for(int i = 1; i < 10; i++){
            dfs(n-1, k, i, set);
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int num: set){
            ans[i] = num;
            i++;
        }
        return ans;
    }
    
    private void bfs(int n, int k, Queue<Integer> q){
        int size = q.size();
        int level = 1;
        while(!q.isEmpty() && level < n){
            if(size > 0){
                int num = q.poll();
                size--;
                int last = num%10;
                if(last + k < 10){
                    q.offer(num*10 + last+k);
                }
                if(last - k >= 0){
                    q.offer(num*10 + last-k);
                }
            }else{
                size = q.size();
                level++;
            }
        }
        
    }
        
    private void dfs(int n, int k, int num, HashSet<Integer> set){
        if(n == 0){
            set.add(num);
            return;
        }
        int last = num%10;
        if(last+k < 10){
            dfs(n-1, k, num*10 + (last+k), set);
        }
        if(last - k >= 0){
            dfs(n-1, k, num*10 + (last-k), set);
        }
    }
}