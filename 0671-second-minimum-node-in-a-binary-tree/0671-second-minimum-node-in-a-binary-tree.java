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
    public int findSecondMinimumValue(TreeNode root) {
        
        //approach using treeset
        TreeSet<Integer> set = new TreeSet();
        setHelper(root, set);
        set.pollFirst();
        if(!set.isEmpty()) return set.pollFirst();
        return -1;
        
        // using comparision and array
        /*long[] min = new long[2];
        min[0] = root.val;
        min[1] = Long.MAX_VALUE;
        helper(root, min);
        return (min[1] == Long.MAX_VALUE) ? -1: (int) min[1];*/
    }
    
    private void setHelper(TreeNode root, TreeSet<Integer> set){
        if(root == null) return;
        set.add(root.val);
        setHelper(root.left, set);
        setHelper(root.right, set);
    }
    
    private void helper(TreeNode root, long[] min){
        if(root == null) return;
        
        if(root.val > min[0] && root.val < min[1])
            min[1] = root.val;
        
        helper(root.left, min);
        helper(root.right, min);
    }
    
}