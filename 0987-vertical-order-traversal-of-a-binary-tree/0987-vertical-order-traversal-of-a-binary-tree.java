/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] minMax = {0,0};
        // tried TreeMap to automatically maintain minMax[] but no performance difference
        // TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<Integer, PriorityQueue<int[]>>();
        HashMap<Integer, PriorityQueue<int[]>> map = new HashMap<Integer, PriorityQueue<int[]>>();

        helper(root, 0, 0, map, minMax);
        List<List<Integer>> ans = new ArrayList<>();
        // for(Map.Entry<Integer,PriorityQueue<int[]>> entry : map.entrySet()) {
            // PriorityQueue<int[]> pq = entry.getValue();
        for(int i = minMax[0]; i <= minMax[1]; i++){
            PriorityQueue<int[]> pq = map.get(i);
            List<Integer> list = new ArrayList();
            while(!pq.isEmpty()){
                int[] ar = pq.poll();
                list.add(ar[2]);
            }
            ans.add(list);
        }
        return ans;
    }
    
    private void helper(TreeNode root, int pos, int level,
                        HashMap<Integer, PriorityQueue<int[]>> map, 
                        // TreeMap<Integer, PriorityQueue<int[]>> map, 
                        int[] minMax){
        if(root == null) return;
        
        PriorityQueue<int[]> pq;
        int[] ar = {level, pos, root.val};
        if(map.containsKey(pos)){
            pq = map.get(pos);
            pq.offer(ar);            
        }else{
            pq = new PriorityQueue<int[]>((a,b)->( // prefer level asc order then prefer lower root.val
                    (a[0]-b[0]!=0 ? a[0]-b[0] : a[2]-b[2])
                ));
            pq.offer(ar);
            map.put(pos, pq);
        }
        
        if(pos <= minMax[0]) minMax[0] = pos;
        if(pos >= minMax[1]) minMax[1] = pos;

        helper(root.left, pos-1, level+1, map, minMax);
        helper(root.right, pos+1, level+1, map, minMax);
    }
}