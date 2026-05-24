class Solution {
    class Pair{
        int freq;
        int val;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Pair> freq = new HashMap<>();

        for(int num : nums){
            freq.computeIfAbsent(num, a->new Pair(num, 0)).freq++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.freq - p1.freq);
        pq.addAll(freq.values());
        int i = 0;
        int[] res = new int[k];
        while(i<k){
            res[i++] = pq.poll().val;
        }
        
        return res;
    }
}
