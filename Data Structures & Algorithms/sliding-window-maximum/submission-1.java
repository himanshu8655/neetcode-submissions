class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(k);

        for(int i = 0; i<k; i++){
            while(!queue.isEmpty() && nums[queue.peekFirst()]<nums[i])
                queue.removeFirst();
            
            queue.offerFirst(i);
            
            
        }
        result[0] = nums[queue.peekLast()];
        int idx = 1;
        for(int i = k; i<nums.length; i++){
            while(queue.peekLast() + k < i){
                queue.removeLast();
            }

            while(!queue.isEmpty() && nums[queue.peekFirst()]<nums[i])
                queue.removeFirst();

            queue.offerFirst(i);
            result[idx++] = nums[queue.peekLast()];
        }
    return result;
    }
}

