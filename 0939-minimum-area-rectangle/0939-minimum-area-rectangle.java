class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        int min = Integer.MAX_VALUE;
        for(int[] i : points){
            // 2,1 - 5,1 - 2,3 - 5,3
            for(int[] j : points){
                if(j[0] == i[0] || j[1] == i[1]){
                    continue;
                }
                if(map.containsKey(j[0]) && map.get(j[0]).contains(i[1]) 
                   && map.containsKey(i[0]) && map.get(i[0]).contains(j[1])){
                    int area = Math.abs((j[0]-i[0]) * (j[1]-i[1]));
                    if(min > area){
                        min = area;
                    }
                }
            }
            map.computeIfAbsent(i[0], v -> new HashSet<Integer>()).add(i[1]);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}