import java.util.ArrayList;
import java.util.List;

public class IntervalAddition {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }
        Interval toInsert = newInterval;
        boolean inserted = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (checkOverlap(toInsert, current)) {
                toInsert.start = Math.min(toInsert.start, current.start);
                toInsert.end = Math.max(toInsert.end, current.end);
                intervals.remove(i);
                i--;
            } else {
                if (toInsert.end < current.start) {
                    intervals.add(i, toInsert);
                    inserted = true;
                    break;
                }
            }
        }
        if (!inserted) {
            intervals.add(intervals.size(), toInsert);
        }
        return intervals;
    }

    private boolean checkOverlap(Interval a, Interval b) {
        return Math.max(a.start, b.start) <= Math.min(a.end, b.end);
    }
}
