class Solution {
    class Pair{
        int freq;
        int no;
        Pair(int freq, int no){
            this.freq = freq;
            this.no = no;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Pair> freq = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            final int num = nums[i];
            freq.computeIfAbsent(num, a->new Pair(0, num)).freq++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o2.freq - o1.freq);
        pq.addAll(freq.values());
        for(Pair pair : freq.values()){
            System.out.println(pair.freq + "---" + pair.no);
        }
        int[] res = new int[k];
        int idx = 0;
        while(k>0 && !pq.isEmpty()){
            k--;
            res[idx++] = pq.poll().no;
        }

        return res;
    }
}
