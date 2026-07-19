class Solution {
    //2 1 -> 2
    //2 1 0 -> 2
    //4 -> 4
    //4 2 -> 4
    //6 
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> queue = new ArrayDeque<>();
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i<nums.length; i++){
            while(!queue.isEmpty() && i - k>=queue.peekFirst()[0]){
                queue.pollFirst();
        }
        while(!queue.isEmpty() && queue.peekLast()[1]<nums[i]){
            queue.pollLast();
        }
        queue.add(new int[]{i, nums[i]});
        if(i+1-k>=0)
            res[idx++] = queue.peekFirst()[1];
        }
        
       return res;
    }
}
