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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        ArrayList<String> list = new ArrayList<String>();
        serializeHelper(root, list);
        
        return String.join(",",list); // String of comma seperated strings of node values
    }
    
    private void serializeHelper(TreeNode node, ArrayList<String> list){
        if(node == null){ 
            list.add("null");
        }else{ // preorder
            list.add(String.valueOf(node.val));
            serializeHelper(node.left, list);
            serializeHelper(node.right, list);   
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        // recursive fun to set left and right nodes from start;
        return deserializeHelper(q); 
    }
    
    // preorder - current node (null check + update left + update right)
    private TreeNode deserializeHelper(Queue<String> q){
        if(q.isEmpty()) return null;
        
        TreeNode root = null;
        String s = q.poll();
        if(!s.equals("null")){
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