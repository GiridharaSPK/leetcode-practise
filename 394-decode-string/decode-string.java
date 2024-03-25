class Solution {
    public String decodeString(String input) {
        
        int index = 0;
        int count = 0;
        String ans = "";
        Stack<String> strings = new Stack();
        Stack<Integer> counts = new Stack();

        while(index < input.length()){
            if(Character.isDigit(input.charAt(index))) {
                count = count*10 + (Character.getNumericValue(input.charAt(index)));
            }else if(input.charAt(index) == '['){
                counts.push(count);
                count = 0;
                strings.push(ans);
                ans = "";
            }else if(input.charAt(index) == ']'){
                int currentCount = counts.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(strings.pop());
                for(int i = 0; i < currentCount; i++){
                    sb.append(ans);
                }
                ans = sb.toString();
            }else{
                ans = ans + input.charAt(index);
            }
            index++;
        }
         return ans;
        
        /*int pointer = 0;
        int count = 0;
        String ans = "";
        String temp = "";
        Stack<Character> s = new Stack<Character>();
        while(pointer < input.length()){
            Character ch = input.charAt(pointer);
            if(ch == ']'){
                temp = "";
                while(!s.isEmpty()){
                    Character popped = s.pop();
                    if(popped == '['){
                        break;
                    } else{
                        temp = popped + temp;
                    }
                }
                String countStr = "";
                while(!s.isEmpty() && s.peek() >= '0' && s.peek() <= '9'){
                    countStr = s.pop() + countStr ;
                }
                count = Integer.parseInt(countStr);
                String rs = ""; //result string 
                for(int i = 0; i < count; i++)
                    rs = temp + rs;
                for(int i = 0; i < rs.length(); i++){
                    s.push(rs.charAt(i));
                }
                
            }else{
                s.push(ch);
            }
            pointer++;
        }
        while(!s.isEmpty()){
            ans =s.pop() + ans;
        }
        return ans;*/
    }
}

// class Stack{

//     private ArrayList<Character> list;
//     private int length = 0;

//     Stack(){
//         this.length = 0;
//         this.list = new ArrayList<Character>();
//     }

//     public void push(Character ch){
//         list.add(ch);
//         length++;
//         return;
//     }
//     public Character peek(){
//         return list.get(length-1);
//     }
//     public Character pop(){
//         Character ch = list.get(length-1);
//         list.removeLast();
//         length--;
//         return ch;
//     }

//     public boolean isEmpty(){ return length == 0;}

// }