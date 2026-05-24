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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int max_ctr = 0;
        int i = 0;
        int j = 0;
        while(i<start.length) {
            if(start[i]<end[j]) {
                count++;
                max_ctr = Math.max(max_ctr, count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return max_ctr;
    }
}
