class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stk = new Stack<Integer>();

        for(int i = 0; i<n; i++){
             while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i]){
                int popValue = stk.pop();
                result[popValue] = i - popValue;
            }
                stk.push(i);
        }

        return result;
    }
}
