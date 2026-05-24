class Solution {
    class Pair{
        int index;
        int value;
        Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.value - p1.value);
        for(int i = 0; i<k; i++){
            pq.offer(new Pair(i, nums[i]));
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        res[0] = pq.peek().value;
        int resIdx = 1;
        for(int i = k; i<n;i++){
            pq.offer(new Pair(i, nums[i]));
            while(!pq.isEmpty() && pq.peek().index<=(i - k)){
                pq.poll();
            }
            res[resIdx++] = pq.peek().value;
        }

        return res;
    }
}
