// void record(int val) to save the record
// double getAvg() to calculate the average value of all records within 5 min

public class MovingAverage {
    class TimedValue {
        int val;
        long time;
        // int size; followup - memory
        public TimedValue(int val, int time) {
            this.val = val;
            this.time = time;
            // this.size = 1; followup
        }
    }

    private Queue<TimedValue> timeWindow;
    // private Deque<TimedValue> timeWindow; folowup - memory
    private double currentSum; // or long
    // int dataNums;
    private int timeWindowSize;

    public MovingAverage(int maxSeconds) { // optional
        timeWindow = new LinkedList<>();
        currentSum = 0.0;
        timeWindowSize = maxSeconds;
        // dataNums = 0; // followup number of data / timedValue
    }

    private int getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    } // no change for followup

    private boolean isExpired(int currentTime, int farthestTime) {
        return currentTime - farthestTime > 300;
    } // no change for followup

    private void removeExpired() { // timeWindow.peekFirst().time - oldest for follwup - memory
        while (!timeWindow.isEmpty() && isExpired(getCurrentTime(), timeWindow.peek().time)) {
            TimedValue toRemove = timeWindow.poll();
            currentSum -= toRemove.val;
            // dataNums -= toRemove.size;
        }
    }

    public void record(int val) {
        TimedValue toAdd = new TimedValue(getCurrentTime(), val);
        timeWindow.offer(toAdd);
        currentSum += val;
        removeExpired();
    }

    // for follwup - memory
    public void record(int val) {
        TimedValue last = timeWindow.peekLast(); // newest/latest element of deque
        if (getCurrentTime() - last.time < 10) { // within 10 second interval - aggregate without adding
            last.size++; // last has not expired
            last.val += val;
        } else { // otherwise have to add to queue
            TimedValue event = new Event(getCurrentTime(), val);
            timeWindow.offer(event);
        }
        dataNums++;
        currentSum += val;
        removeExpired();
    }

    public double getAvg() {
        removeExpired();
        if (!timeWindow.isEmpty()) {
            return currentSum / timeWindow.size();
            // return (double) currentSum / dataNums; followup - memory
        }
        return 0.0;
    }

    public double getMedian() { // followup
        removeExpired();
        int[] temp = new int[timeWindow.size()];
        for (int i = 0; i < timeWindow.size(); i++) {
            TimedValue toCopy = timeWinow.poll();
            temp[i] = toCopy.val;
            // timeWindow.offer(toCopy); recovers queue
        }
        int len = temp.length;
        if (len % 2 == 0) { // even
            return 0.5 * (findKth(temp, len / 2, 0, len - 1) + findKth(temp, len / 2 - 1, 0, len - 1));
        }
        return (double) findKth(temp, len / 2, 0, len - 1); // odd
    }

    private int findKth(int[] temp, int k, int start, int end) { // quickselect algo Hoare partition
        int pivot = temp[start];  // pivot value
        int left = start;
        int right = end;
        while (left < right) {
            while (temp[right] > pivot && left < right) {
                right--; // more than pivot
            }
            while (temp[left] <= pivot && left < right) {
                left++;
            }
            swap(temp, left, right);
        }
        swap(temp, start, right);
        if (k == right) {
            return pivot;
        } else if (k < right) {
            return findKth(temp, k, start, right - 1); // left partition
        }
        return findKth(temp, k, right + 1, end); // right partition
    } // O(n) average case

    priavte void swap(int[] temp, int left, int right) {
        int num = temp[left];
        temp[left] = temp[right];
        temp[right] = num;
    }
}
