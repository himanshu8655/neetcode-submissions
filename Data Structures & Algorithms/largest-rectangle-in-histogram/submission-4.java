class Solution {

    class Pair{
        int val;
        int index;

        Pair(int index, int val){
            this.val = val;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Pair> queue = new ArrayDeque<>();
        int result = 0;
        for(int i = 0; i<heights.length; i++){
            Pair lastPair = new Pair(i, heights[i]);
            while(!queue.isEmpty() && heights[i]<=queue.peekLast().val){
                lastPair = queue.removeLast();
                result = Math.max(lastPair.val*(i - lastPair.index), result);
            }
            lastPair.val = heights[i];
            queue.offerLast(lastPair);
        }
        System.out.println(queue);
        while(!queue.isEmpty()){
            Pair lastPair = queue.peekLast();
            Pair firstPair = queue.removeFirst();
            result = Math.max(result, (lastPair.index - firstPair.index+1)*firstPair.val);
        }
    return result;
    }
}
