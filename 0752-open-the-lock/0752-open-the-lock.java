class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String i : deadends){
            set.add(i);
        }
        int[] src = {0,0,0,0};
        int[][] dir =  {{9,0,0,0}, {1,0,0,0}, 
                        {0,9,0,0}, {0,1,0,0}, 
                        {0,0,9,0}, {0,0,1,0},
                        {0,0,0,9}, {0,0,0,1}};
        int depth = 0;
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(src);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
                int[] temp = q.poll();
                size--;
                
                StringBuilder sb = new StringBuilder();
                sb.append(temp[0]);
                sb.append(temp[1]);
                sb.append(temp[2]);
                sb.append(temp[3]);
                String tempStr = sb.toString();
                
                if(tempStr.equals(target)){
                    return depth;
                }
                
                if(set.contains(tempStr)){
                    continue;
                }
                set.add(tempStr);
                
                for(int[] d: dir){
                    q.add(new int[]{(temp[0]+d[0])%10, (temp[1]+d[1])%10, (temp[2]+d[2])%10, (temp[3]+d[3])%10});
                }
            }

            depth++;
        }
        return -1;
    }
}