class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        Stack<int[]> result = new Stack<>();
        result.push(intervals[0]);
        int n = intervals.length;

        for(int i = 1; i<n; i++){
            int[] peekInterval = result.peek();
            if(intervals[i][0]<=peekInterval[1]){
                peekInterval[1] = Math.max(peekInterval[1], intervals[i][1]);
            }
            else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
