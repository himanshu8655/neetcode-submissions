class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i<n; i++){//i = 5
            //38 36 
            int temp = temperatures[i]; // 40

                while(!stack.isEmpty() && temperatures[stack.peekLast()]<temp){
                    int idx = stack.pollLast(); //4
                    res[idx] = i - idx; //1
                }
            
            stack.offerLast(i);

        }

        return res;
    }
}
