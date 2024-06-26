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
        
        // Morris traversal: O(n) time and constant space
        // alter the links of left childs such that we just need to traverse right every time
        // so finally we have no left childs,
        // keep adding current node to answer list whenever there is no left node
        ArrayList<Integer> list = new ArrayList();
        TreeNode node = root;
        TreeNode temp = root;
        while(node!=null){
            // if current node has left child
            // alter link of its right most child and point it to current node
            if(node.left!=null){
                TreeNode left = node.left;
                while(left.right!=null){
                    left = left.right;
                }
                // assign right of least child to current node (inorder traversal)
                left.right = node;
                temp = node;
                node = node.left; // move leftwards for inorder traversal
                temp.left = null; //mark left of current node to null (to avoid loop)
            }else{ // no left node 
                list.add(node.val); // add current node to answer
                node = node.right; // move right
            }
        }
        return list;
        
        //iterative approach
        /*ArrayList<Integer> list = new ArrayList();
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
        return list;*/
        
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