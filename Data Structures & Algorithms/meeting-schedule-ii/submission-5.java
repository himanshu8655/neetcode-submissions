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
        Collections.sort(intervals, (a,b)->a.start - b.start);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(rooms.isEmpty())
                rooms.add(interval.end);
            else{
                int minMeetingInterval = rooms.peek();
                if(minMeetingInterval>interval.start)
                    rooms.add(interval.end);
                else{
                    rooms.poll();
                    rooms.add(interval.end);
                }
            }
        }
        return rooms.size();
    }
}
