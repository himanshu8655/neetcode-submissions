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
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq - a.freq);
        for(Pair pair : freq.values()){
            pq.offer(pair);
        }
        while(!pq.isEmpty() && k>idx){
            res[idx++] = pq.poll().val;
        }
        return res;
    }
}
