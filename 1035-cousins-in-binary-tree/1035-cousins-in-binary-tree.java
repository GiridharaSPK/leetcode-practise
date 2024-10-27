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
        if(root.val == x || root.val == y) return false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            boolean found = false;
            while(n > 0){
                TreeNode curr = queue.poll();
                n--;    
                boolean justFound = false;
                if(curr.left!=null){ 
                    queue.offer(curr.left);
                    if(curr.left.val == x || curr.left.val == y){
                        if(found){
                            return true;
                        }
                        justFound = true;
                        found = true;
                    }
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    if (curr.right.val == x || curr.right.val == y){
                        if(justFound){
                            return false;
                        }else{
                            if(found) return true;
                        }
                        found = true;
                    }
                }
            }
        }

        return false;

    }
}