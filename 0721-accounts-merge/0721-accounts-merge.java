class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        
        int[] rank = new int[n];
        for(int i = 0; i < rank.length; i++)
            rank[i] = 1;
        
        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        // traversing accross accounts
        for(int i = 0; i < n; i++){ 
            // traversing emails of an account
            for(int j = 1; j < accounts.get(i).size(); j++){ 
                String currMail = accounts.get(i).get(j);
                // mapped every email to an index
                if(!map.containsKey(currMail)){
                    map.put(currMail, i);
                }else{
                    union(map.get(currMail), i, parent, rank);
                }
            }
        }
        
        // traverse all the nodes
        for(int i = 0; i < n; i++){
            
            int p = find(i, parent); 
            // have to use find(i) instead of parent[i] 
            // as path compression occarance isnt guranteed until first call happens
            
            // if it is not a parent - merge both
            if(p != i && !accounts.get(i).isEmpty()){
                // add all of childs emails to parents list
                List<String> parentAccount = accounts.get(p);
                TreeSet<String> set = new TreeSet<String>();
                for(int j = 1; j < parentAccount.size(); j++){
                    set.add(parentAccount.get(j));
                }
                for(int j = 1; j < accounts.get(i).size(); j++){
                    set.add(accounts.get(i).get(j));
                }
                String parentAccountName = parentAccount.get(0);
                parentAccount.clear();
                parentAccount.add(parentAccountName);
                parentAccount.addAll(new ArrayList(set));
                // clear current account
                accounts.get(i).clear();
                
            }else{ // the index is a parent - sort the list
                List<String> account = accounts.get(p);
                TreeSet<String> set = new TreeSet<String>();
                for(int j = 1; j < account.size(); j++){
                    set.add(account.get(j));
                }
                String accountName = account.get(0);
                account.clear();
                account.add(accountName);
                account.addAll(new ArrayList(set));
            }
        }
        accounts.removeIf(List::isEmpty);
        
        /*for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).isEmpty()){
                accounts.remove(i);
                i--; // modifying the traversing list - need to take care of the index
            }
        }*/
        
        return accounts;
    }
    
    private void union(int i1, int i2, int[] parent, int[] rank){
        int p1 = find(i1, parent);
        int p2 = find(i2, parent);
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }else if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }else{
            parent[p1] = p2;
            rank[p1]++;
        }
    }
    
    private int find(int u, int[] parent){
        int p = parent[u];
        if(p == u) return p;
        
        int temp = find(parent[u], parent);
        parent[u] = temp;
        return temp;
    }
    
}