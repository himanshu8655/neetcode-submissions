/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)->a.start - b.start);
        int n = intervals.size();

        for(int i = 1; i<n; i++){
            Interval prevInterval = intervals.get(i-1);
            Interval currInterval = intervals.get(i);
           if(prevInterval.start<currInterval.start && prevInterval.end>currInterval.start)
            return false;

            if(prevInterval.start<currInterval.end && prevInterval.end>currInterval.end)
            return false;
        }

        return true;   
    }
}
