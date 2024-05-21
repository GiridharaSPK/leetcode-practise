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
        preorderAdd(root, list);
        
        return String.join(",", list);
    }
    
    private void preorderAdd(TreeNode node, ArrayList<String> list){
        if(node == null) 
            list.add("null");
        else{
            list.add(String.valueOf(node.val));
            preorderAdd(node.left, list);
            preorderAdd(node.right, list);   
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        List<String> temp = Arrays.asList(data.split(","));
        ArrayList<String> list = new ArrayList();
        list.addAll(temp);
        return read(list); // recursive fun to set left and right nodes from start;
    }
    
    // preorder - current node (null check + update left + update right)
    private TreeNode read(ArrayList<String> list){
        if(list.isEmpty()) return null;
        
        TreeNode root = null;
        String s = list.remove(0);
        if(!s.equals("null")){
            root = new TreeNode(Integer.parseInt(s));
        }
        if(root != null){
            root.left = read(list);
            root.right = read(list);
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));