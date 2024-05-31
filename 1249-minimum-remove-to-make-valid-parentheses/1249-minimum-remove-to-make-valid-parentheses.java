class Solution {
    public String minRemoveToMakeValid(String s) {
        // appraoch without stack - neetcode
        int count = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(count <= 0){
                  // these chars should be removed
                    chars[i] = '-';
                }else{
                    count--;
                }
            }else if(c == '('){
                count++;
            }else{
                // chars[i] = // dont do anything 
            }
        }
        int i = chars.length-1;
        // remove extra '('s
        while(count > 0){
            if(chars[i] == '('){
                chars[i] = '-';
                count--;
            }
            i--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < chars.length; i++){
            if(chars[i]!='-')
                sb.append(""+chars[i]);
        }
        return sb.toString();
        
        // approach with stacks - pepcoding
        // use stack to locate positions of invalid parantheses
        // writing all test casees and dry running them is important
        // (()))(), ))(()), )))(((, - dont miss multiple extras
       /* Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == ')' && stack.isEmpty()){ // seen an invalid ')' 
                stack.push(i);
            }else if(c == ')' && s.charAt(stack.peek()) == '('){ 
                stack.pop();
            }else if(c == ')' && s.charAt(stack.peek()) == ')'){// seen an invalid ')' 
                stack.push(i);
            }
        }
        // stack contains all invalid parantheses
        if(stack.isEmpty()) return s;
        
        // positions to be ingored in reverse order in stack
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            if(!stack.isEmpty() && stack.peek() == i){
                stack.pop();
            }else{
                sb.append(""+s.charAt(i));
            }
        }
        
        return sb.reverse().toString();*/
    }
}