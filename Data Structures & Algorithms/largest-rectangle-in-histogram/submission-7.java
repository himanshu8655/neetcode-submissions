class Solution {
    class Pair{
        int height;
        int index;
        Pair(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque<>();
        int result = 0;
        for(int i = 0; i<heights.length; i++){
            int height = heights[i];
            Pair p = new Pair(height, i);
            while(!stack.isEmpty() && stack.peekLast().height>height){
                Pair topPair = stack.pollLast();
                result = Math.max(result, (i - topPair.index) * topPair.height);
                p.index = topPair.index;
            }
           
            stack.offerLast(p);
        }

        while(!stack.isEmpty()){
            Pair topPair = stack.pollFirst();
            result = Math.max(result, (heights.length - topPair.index)*topPair.height);
        }

        return result;
    }
}
