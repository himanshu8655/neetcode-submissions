class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            else return a[0] - b[0];
        });
        int result = 0;
        int[] prevInterval = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]<prevInterval[1]){
                result++;
            }
            else{
                prevInterval = intervals[i];
            }
        }
        return result;
    }
}
