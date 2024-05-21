class Solution {
    // test cases or questions or scenarios to think of
    // 1 - nested brackets[]
    // 2 - always a number exists
    // 3 - does every substring has a number? i.e. 1[ef] or just ef
    // 4 - tailing characters - dont forget chars not part of stack in the end
    // 5 - does it always start with num and end with ]?

    public String decodeString(String s) {
              
        // approach1: using a single stack
        
        // Use Stack to push all not just numbers,
        // use same stack for all chars 
        // and pop at ] until [ and number and repeat;
        
        Stack<String> stack = new Stack<String>();
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

        String ans = "";
        while(!stack.isEmpty()){
           ans = stack.pop()+ans;
        }
        return ans;
        
        // approach2: using 2 stacks - counts and strings - slower than approach 1
        /*
        Stack<Integer> counts = new Stack<Integer>();
        Stack<String> strings = new Stack<String>();        
        String strNum = ""; // String(num) - variable to perform logic 
        
        // normal chars keep append to string 
        String str = ""; // stores current string
        
        // at digit keep appending strNum (add to stack at '[' )
        
        // at [ (have to multiply) and (possibility of nesting)
        // so, add existing string to string stack - to pop after resolving current str
        // and add count to count stack
        // reset str (and strNum)
        
        // between [ and ] and not digit
        // keep appending str (store currently traversing string - has freq top of counts)
        
        // at ] pop the count and resolve current str 
        // after resolving append to actual string which is on top of strings stack
        // 
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
            // closing current string - resolve and append with top of stack

                // pop count 
                int n = counts.pop();

                // resolve str num times
                String temp = "";
                while(n>0){ 
                    n--;
                    temp += str;
                }
                str = strings.pop() + temp;
            }else if(Character.isDigit(ch)){
                // keep adding to strNum (add to count stack at '[' )
                strNum += String.valueOf(ch);
            }else if(ch == '['){
                // adding count of current string to count stack
                counts.push(Integer.parseInt(strNum));
                // adding prev str to strings, 
                // (will pop it and append with current string is done at ])
                strings.push(str);
                strNum = "";
                str = "";
            }else{
                // normal chars keep append to string 
                str = str + ch;
            }
        }
        
        return str;*/
        
    }
}