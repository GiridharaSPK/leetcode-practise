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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = inorder(root, new ArrayList());
        if(list.size() > k-1) return list.get(k-1);
        return -1;
    }
    
    private ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> list){
        if(node == null) return list;
        
        if(node.left!=null){
            inorder(node.left, list);
        }
        
        list.add(node.val);
        
        if(node.right!=null){
            inorder(node.right, list);
        }
        
        return list;
    }
    
}