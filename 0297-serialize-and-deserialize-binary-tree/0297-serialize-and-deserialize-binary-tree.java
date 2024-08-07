/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    final String seperator = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        return serializeHelper(root, new StringBuilder()).toString();
    }
    
    private StringBuilder serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null){ 
            sb.append("N").append(seperator);
        }else{ // preorder
            sb.append(String.valueOf(node.val)).append(seperator);
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);   
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {     
        // can use a list to traverse 
        // - but a queue is more efficient
        // --  as we remove first node everytime
        Queue<String> q = new LinkedList(Arrays.asList(data.split(seperator)));
        // recursive fun to set left and right nodes from start;
        return deserializeHelper(q); 
    }
    
    // preorder - current node (null check + update left + update right)
    private TreeNode deserializeHelper(Queue<String> q){
        if(q.isEmpty()) return null;
        
        TreeNode root = null;
        String s = q.poll();
        if(!s.equals("N")){
            root = new TreeNode(Integer.parseInt(s));
        }
        if(root != null){
            root.left = deserializeHelper(q);
            root.right = deserializeHelper(q);
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));