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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y) return false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depthX = -1;
        int depthY = -2;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode curr = queue.poll();
                size--;    
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.val == x){
                    depthX = level;
                }
                if(curr.val == y){
                    depthY = level;
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            level++;
        }
        return depthX == depthY;

    }
}