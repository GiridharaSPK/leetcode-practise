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
    public List<Integer> inorderTraversal(TreeNode root) {
        //iterative approach
        ArrayList<Integer> list = new ArrayList();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(!s.isEmpty() || node!=null){
            //left
            while(node!=null){
                s.push(node);
                node = node.left;
            }
            //current node
            node = s.pop();
            list.add(node.val);

            //right
            node = node.right;
        }
        return list;
        // recursive approach
        // return helper(root, new ArrayList<Integer>());
    }
    
    private List<Integer> helper(TreeNode node, ArrayList<Integer> list){
        if(node != null){
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
        return list;   
    }
}