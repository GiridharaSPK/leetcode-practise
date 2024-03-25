class Solution {
    public String decodeString(String input) {
        int pointer = 0;
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
        return ans;
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