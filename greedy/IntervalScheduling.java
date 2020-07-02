
public class IntervalScheduling {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int lastEnd = intervals[0].end;
        int disjoints = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= lastEnd) {
                disjoints++;
                lastEnd = intervals[i].end;
            }
        }
        return intervals.length - disjoints;
    }
}
