class Solution {
    class Pair{
        int freq;
        int val;

        Pair(int freq, int val){
            this.freq = freq;
            this.val = val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Pair> freq = new HashMap<>();

        for(int num : nums){
            freq.computeIfAbsent(num, z->new Pair(0, num)).freq++;
        }
        int[] res = new int[k];
        int idx = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(k,(a,b)->a.freq - b.freq);
        for(Pair pair : freq.values()){
            pq.offer(pair);
            if(pq.size()>k)
                pq.poll();
        }
        while(!pq.isEmpty()){
            res[idx++] = pq.poll().val;
        }
        return res;
    }
}
