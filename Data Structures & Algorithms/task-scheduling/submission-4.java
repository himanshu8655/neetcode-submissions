class Solution {
    //x:2
    //y:2
    //pq = []
    //Queue = [[3, 1]]
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int time = 0;
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<26; i++){
            if(freq[i]>=1)
                pq.add(freq[i]);
        }
        //pq = [1]
        //queue = [[4, 2]]
        //time  = 4
        Queue<int[]> queue = new LinkedList<>();

        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(pq.isEmpty()){
                int[] task = queue.poll();
                time = task[0];
                pq.offer(task[1]);
            }
            else{
                int taskFrequency = pq.poll();
                if(taskFrequency>1)
                    queue.add(new int[]{time + n, taskFrequency - 1});
                if(!queue.isEmpty() && time == queue.peek()[0])
                    pq.offer(queue.poll()[1]);
            }
            
        }

        return time;
    }
}
