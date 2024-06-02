/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // DFS - faster
        // HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        // return clone(node, map);
        
        // BFS - slower
        // node can be null - map cannot always work with <int,node>
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> q = new LinkedList<Node>();

        q.offer(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null) continue;
            if(!map.containsKey(curr)){
                map.put(curr, new Node(curr.val));
            }
            // add children                
            for(Node n : curr.neighbors){ // old neighbors
                Node neighbor; // new neighbors
                if(map.containsKey(n)){
                    neighbor = map.get(n);
                }else{
                    neighbor = new Node(n.val);
                    map.put(n, neighbor);
                    q.offer(n);// adding only unvisted nodes to q 
                    // we dont have any visited map or set
                }
                //  q.offer(n) - dont pass to q if already in map (already visited)
                map.get(curr).neighbors.add(neighbor);
            }
        }
        
        return map.get(node);
    }
    
    private Node clone(Node node, HashMap<Integer, Node> map){
        if(node == null) return null;
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }else{
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            
            for(Node n : node.neighbors){
                newNode.neighbors.add(clone(n, map));
            }
            
            return newNode;
        }
    }
    
}