class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hmp = new HashMap<>();
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->b[1] - a[1]);
        for(int num : nums){
            hmp.put(num, hmp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : hmp.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.offer(new int[]{key, val});
        }

        int i = 0;
        int[] res = new int[k];
        while(!pq.isEmpty() && k>0){
            k--;
            res[i++] = pq.poll()[0];
        }
        return res;
    }
}
