class MyQueue {
    Stack <Integer> stack = new Stack<>();
    Stack <Integer> revStack = new Stack<>();

    public MyQueue() { 
    }
    
    public void push(int x) {
        if(stack.size()==0){
            stack.push(x);
            return;
        }
        while(stack.size()!=0){
            revStack.push(stack.pop());
        }

        stack.push(x);

        while(revStack.size()!=0){
            stack.push(revStack.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
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