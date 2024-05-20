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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        // run bfs as is 
        // maintain a size variable to monitor end of level
        // whenever size == 0 (last node of the level), just add to list
        int size = q.size();
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
            
            size--;
            if(size == 0){ 
                list.add(node.val);
                size = q.size();
            }
        }
        
        return list;
    }
}