class MinStack {

    class Pair{
        int min;
        int val;
        Pair(int min, int val){
            this.min = min;
            this.val = val;
        }
    }
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair pair = new Pair(val, val);
        if(!stack.isEmpty()){
            Pair prev = stack.peek();
            if(prev.min<pair.min)
                pair.min = prev.min;
        }
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
