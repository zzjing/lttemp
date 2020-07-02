
public class MinMeetingRooms {
    public boolean canAttendAllMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // sort the start times and end times of the intervals, respectively
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        // assertion: for any end time, there exists a start time before it
        int curEnd = 0;
        int minRooms = 0;
        for (int i = 0; i < startTimes.length; i++) {
            int startTime = startTimes[i];
            // possible multiple meetings start before one of them ends
            // thus there exist overlapping meetings -> allocate more rooms
            if (startTime < endTimes[curEnd]) {
                minRooms++;
            } else { // otherwise at least one meeting ends, can move another meeting to that room
                curEnd++;
            }
        }
        return minRooms;
    }
}
