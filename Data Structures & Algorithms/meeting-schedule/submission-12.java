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
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        if(intervals.size() == 1)
            return true;
        
        for(int i = 1; i<intervals.size(); i++){
            Interval prevInterval = intervals.get(i-1);
            Interval currInterval = intervals.get(i);

            if(currInterval.start<prevInterval.end)
                return false;
        }  

        return true;
    }
}
