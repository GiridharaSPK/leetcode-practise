class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    // approach 1 - putting a possible peek element in a separate stack s2
    // push, peek, isEmpty is O(1) 
    // pop is every time O(n)
    
    // apporoach 2 - average/ amortized O(1) for all operations
    // dont shuffle between stacks every time for push/pop
    // only do when required

    public void push(int x) {
        // approach 2
        s1.push(x);
        
        // approach 1
        /*
        if(s2.isEmpty()){
            s2.push(x); //s2 has only 1 element
        }else{
            s1.push(x);
        }
        */
    }
    
    public int pop() {
        // approach 2 (follow up)
        if(!s2.isEmpty())
            return s2.pop();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
        
        // approach 1 
        /* int popped = s2.pop();
        // put everything from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        if(!s2.isEmpty()){ // ** important check
            int temp =  s2.pop(); //has to be re inserted to s2
            // clear all s2 and push to s1
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s2.push(temp);
        }

        return popped;*/
    }
    
    public int peek() {
        //approach 2
        if(!s2.isEmpty())
            return s2.peek();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
        
        // approach 1
        // return s2.peek();
    }
    
    public boolean empty() {
        // approach 2
        return s1.isEmpty() && s2.isEmpty();
        
        // approach 1
        // return s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */