class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int max = 0;
        for(int r = 0; r < wall.size(); r++){
            int sum = 0;
            for(int i = 0; i < wall.get(r).size() - 1; i++){
                sum = sum + wall.get(r).get(i);
                count.put(sum, count.getOrDefault(sum, 0) + 1);
                if(max < count.get(sum)) max = count.get(sum);
            }
        }
        
        // check at max cut
        return wall.size() - max;
    }
}