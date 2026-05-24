class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for(int i = 0; i<tokens.length; i++){
            if(set.contains(tokens[i])){
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                int sum=operation(num2, num1, tokens[i]);
                stack.offerLast(sum);
            }
            else{
                stack.offerLast(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pollLast();
    }

    public int operation(int num1, int num2, String op){
        if(op.equals("+"))
            return num1 + num2;
        
        else if(op.equals("-"))
            return num1 - num2;

        else if(op.equals("*"))
            return num1 * num2;
        
        else{
            return num2 == 0 ? 0 : num1/num2;
        }
    }
}
