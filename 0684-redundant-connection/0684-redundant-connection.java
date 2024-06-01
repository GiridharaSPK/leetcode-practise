class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n]; //given all nodes are connected and an extra
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        int[] rank = new int[n]; // represents depth
        for(int i = 0; i < n; i++) 
            rank[i] = 1;
        
        for(int[] e : edges){
            if(!union(e[0]-1, e[1]-1, parent, rank)) return e;
        }
        return new int[2];
    }
    
    private boolean union(int u, int v, int[] parent, int[] rank){ // O(logn)
        int pu = find(u, parent);
        int pv = find(v, parent);
        // union by rank 
        if(pu == pv) 
            return false;
        
        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }else if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }else {
            parent[pu] = pv;
            rank[pv]++;
        }
        return true;
    }
    
    private int find(int u, int[] parent){ // O(logn)
        if(parent[u] == u) 
            return u;
        int temp = find(parent[u], parent); 
        parent[u] = temp; // path compression
        return temp;
    }
    
}