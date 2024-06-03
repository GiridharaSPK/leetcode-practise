class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        ArrayList<int[]> ans = new ArrayList();
        int[] curr = intervals[0];
        int n = intervals.length;
        ans.add(curr);
        for(int i = 1; i < n; i++){
            if(curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                curr = intervals[i];
                ans.add(intervals[i]);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}