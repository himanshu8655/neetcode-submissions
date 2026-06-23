class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1)
            return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        Stack<int[]> res = new Stack<>();
        res.add(intervals[0]);
        for(int i = 1; i<n; i++){
            int[] prev = res.peek();
            if(prev[1]>=intervals[i][0]){
                res.pop();
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
                res.add(prev);
            }
            else{
                res.add(intervals[i]);
            }
            
        }
    return res.toArray(new int[res.size() - 1][2]);
    }
}
