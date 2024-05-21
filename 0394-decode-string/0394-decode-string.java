class Solution {
    public String decodeString(String s) {
        // test cases - nested brackets[]
        // test cases - always number
        // every substring has a number? i.e. 1[ef] or just ef
        
        // Use Stack to push all not just numbers,
        // use same stack for all chars 
        // and pop at ] until [ and number and repeat;
        
        Stack<String> stack = new Stack();
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                // found closing bracket
                
                // read string until [
                String temp = "";
                while(!stack.isEmpty()){
                    if(stack.peek().equals("[")){
                        stack.pop();
                        break;
                    }
                    temp = stack.pop() + temp;
                }
                // read number - until stack is empty or not a digit
                if(!stack.isEmpty()){
                    num = 0;
                    String strNum = "";
                    while(!stack.isEmpty()){
                        if(!Character.isDigit(stack.peek().charAt(0)))
                            break;
                        strNum = stack.pop() + strNum;
                    }
                    num = Integer.parseInt(strNum);
                }
                // add the resolved string to stack num times(3[a] -> a,a,a)
                while(num > 0){
                    num--;
                    stack.push(temp);
                }
            }else{
                // push nums, chars, [ to stack
                stack.push(String.valueOf(ch));
            }
        }

        String a = "";
        while(!stack.isEmpty()){
           a = stack.pop()+a;
        }
        return a;
        
    }
}