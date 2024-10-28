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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;
        List<Integer> sums = levelOrderSum(root);
        root.val = 0;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(level < sums.size()-1){
            int size = q.size();
            while(size > 0){
                TreeNode curr = q.poll();
                size--;
                int childSum = 0;
                if(curr.left!=null){
                    childSum += curr.left.val; 
                }
                if(curr.right!=null){
                    childSum += curr.right.val;
                }
                int temp = sums.get(level+1) - childSum;
                if(curr.left!=null){
                    curr.left.val = temp;
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val = temp;
                    q.offer(curr.right);
                }
            }
            level++;
        }
        return root;
    }

    private List<Integer> levelOrderSum(TreeNode node){
        if(node == null) return Collections.singletonList(0);
        ArrayList<Integer> sums = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(node);
        // int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left!= null) q.offer(curr.left);
                if(curr.right!= null) q.offer(curr.right);
            }
            sums.add(sum);
            // level++;
        }

        return sums;
    }

}