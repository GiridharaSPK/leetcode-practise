class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        
        int len = s.length();
        if(len%2 == 1) return false;
        
        Stack<Character> stack = new Stack<Character>();
        int p = 0;
        
        while(p < len){
            char c = s.charAt(p);
            
            // add to stack - open brackets
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if(stack.isEmpty())// encountered non opening char
                return false;
            else{
                // closing brackets without matching opening
                // take care about stack empty exception 
                if(c == ')' && (stack.peek() != '(')) return false;
                if(c == '}' && (stack.peek() != '{')) return false;
                if(c == ']' && (stack.peek() != '[')) return false;

                // found matching closing brackets
                // remove the opening bracket
                stack.pop();
            }
            p++;
        }
        return stack.isEmpty();
    }
}