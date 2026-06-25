class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();//[1, 2]
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i = 0; i<n; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }//2<3
            while(!queue.isEmpty() && queue.peekFirst() + k<=i)
                queue.pollFirst();

                queue.offerLast(i);
            
            if(i - k +1>=0)
                res[i - k + 1] = nums[queue.peekFirst()];
        }

        return res;
    }
}
