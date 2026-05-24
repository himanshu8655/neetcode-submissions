class MinStack {

    class Pair{
        int val;
        int min;

        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Deque<Pair> deque;

    public MinStack() {
        deque = new ArrayDeque<>();
    }
    
    public void push(int val) {
        Pair pair = new Pair(val, val);
        
        if(!deque.isEmpty())
            pair.min = Math.min(deque.peekLast().min, pair.min);

        deque.offerLast(pair);
    }
    
    public void pop() {
        deque.pollLast();
    }
    
    public int top() {
        return deque.peekLast().val;
    }
    
    public int getMin() {
        return deque.peekLast().min;
    }
}
