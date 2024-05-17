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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root!=null)
            q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            ArrayList<Integer> list = new ArrayList();
            while(count > 0){
                count--;
                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(list);
            count = q.size();
        }
        return ans;
    }
}