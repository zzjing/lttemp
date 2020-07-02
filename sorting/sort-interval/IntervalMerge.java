/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class IntervalMerge {
    public List<Interval> inPlaceMerge(List<Interval> intervals) {
        // time O(n^2) -- ArrayList, space O(1)
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // sort Interval objects per their left bound
        Collections.sort(intervals, ((a, b) -> (a.start - b.start)));
        Interval prev = intervals.get(0); // the first prev interval is the first one
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (prev.end >= current.start) { // overlap found, merge
                // note prev.end >= current.end is possible
                prev.end = Math.max(prev.end, current.end); // merge to the prev interval
                intervals.remove(i); // remove the current interval
                i--; // shift the index backwards
            } else { // disjoint
                prev = current; // update prev (w/o removal)
            }
        }
        return intervals;
    }

    public List<Interval> merge(List<Interval> intervals) {
        // time O(nlogn), space O(n)
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // sort Interval objects per their left bound
        Collections.sort(intervals, ((a, b) -> (a.start - b.start)));
        List<Interval> merged = new LinkedList<Interval>();
        Interval prev = intervals.get(0); // the first prev interval is the first one
        // fence post problem: merge intervals (if necessary), then add it to the list
        // i.e. we would always add the "prev" interval to the list
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (prev.end >= current.start) { // overlap found, merge
                // note prev.end >= current.end is possible
                prev.end = Math.max(prev.end, current.end);
            } else { // disjoint
                merged.add(prev);
                prev = current; // update prev
            }
        }
        // remember to solve fence post, add the last one
        merged.add(prev);
        return merged;
    }
}
