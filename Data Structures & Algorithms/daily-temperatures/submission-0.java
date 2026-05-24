class Solution {
    class Pair{
        int idx;
        int val;
        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stk = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            int temp = temperatures[i];
            while(!stk.isEmpty() && stk.peekLast().val<temp){
                Pair pair = stk.pollLast();
                res[pair.idx] = i - pair.idx;
            }
            stk.offerLast(new Pair(i, temp));
        }

        return res;
    }
}
