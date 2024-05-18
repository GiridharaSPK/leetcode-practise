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
        
        //iterative approach  ( = stack + logic of recursive)
        int count = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(!s.isEmpty() || node != null){ // inorder traversal
            //left
            while(node!=null){
                s.push(node);
                node = node.left;
            }
            
            //current
            node = s.pop();
            count++;
            if(count == k) return node.val;
                
            //right
            node = node.right;
        }
        
        return -1;
        
        //recursive approach
        /*ArrayList<Integer> list = inorder(root, new ArrayList(), k-1);
        if(list.size() > k-1) return list.get(k-1);
        return -1;*/
    }
    
    private ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> list, int k){
        if(node == null || list.size() > k) return list;
        
        if(node.left!=null){
            inorder(node.left, list, k);
        }
        
        list.add(node.val);
        
        if(node.right!=null){
            inorder(node.right, list, k);
        }
        
        return list;
    }
    
}