class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(k);//[1, ]

        for(int i = 0; i<n; i++){
            while(!queue.isEmpty() && i-k>=queue.peekFirst())
                queue.pollFirst();

            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
                queue.pollLast();
            
            queue.offerLast(i);
            System.out.println(queue);
            if(i - k + 1>=0)
                result[i-k+1] = nums[queue.peekFirst()];
        }
        return result;
    }
}

