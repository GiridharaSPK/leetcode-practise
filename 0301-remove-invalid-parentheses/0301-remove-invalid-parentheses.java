class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = s.length();
        List<String> ans = new ArrayList<String>();
        HashSet<String> visited = new HashSet<String>();
        int c = removeCount(s);
        // BFS
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        
        while(!q.isEmpty()){
            String str = q.poll();
            int count = removeCount(str);
            if(count == 0){
                ans.add(str);
                continue;
            }
            if(str.length() < l-c) // removed more than req chars
                continue;
            
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.deleteCharAt(i);
                    String t = sb.toString();
                    if(!visited.contains(t)){
                        q.add(t);
                        visited.add(t);
                    }
                }
            }
            
        }
        return ans;
        
        // DFS approach of removing a char at each level is giving TLE
        /*int remCount = removeCount(s);
        if(remCount == 0) 
            return new ArrayList<String>();
        helper(s, ans, remCount);
        return new ArrayList(ans);*/
    }
    
    private void helper(String s, HashSet<String> ans, 
                        int remCount){
        if(remCount == 0 && removeCount(s) == 0){
            ans.add(s);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(i >0 && s.charAt(i) == s.charAt(i-1)) 
                continue;
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.deleteCharAt(i);
                helper(sb.toString(), ans, remCount-1);
            }
        }
        
    }
    
    private int removeCount(String s){ 
        // how many chars have to be removed in a given string
        int openCount = 0;
        int closedCount = 0;
         for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openCount++;
            }else if(c == ')'){
                if(openCount <= 0){
                    closedCount++;
                }else{
                    openCount--;
                }
            }
         }
        
        return openCount+closedCount;
        
        /*Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
        */
    }
}