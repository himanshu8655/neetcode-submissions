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
        Collections.sort(intervals, (i1,i2)->i1.start-i2.start);
        Interval prev_interval = null;
        for(Interval interval : intervals){
            if(prev_interval == null)
                prev_interval = interval;
            else{
                
                if(interval.start - prev_interval.end<0){
                    return false;
                }
                                    prev_interval = interval;

            }
        }
        return true;
    }
}
