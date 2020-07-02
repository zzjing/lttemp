/**
 * Compute and return the real-time median of 
 * a sequence of numbers. Version 1.
 * @author Zezhou Jing, University of Washington
 * @date December 15, 2016
 */
import java.util.*;

public class MedianMaintainance {
    // "lower half" of the data stream
    private PriorityQueue<Integer> heapLow;
    // "higher half" of the data stream
    private PriorityQueue<Integer> heapHigh;
    // additional field: current size of the data stream
    private int dataSize;
    // constructor
    public MedianMaintainer() {
        // max heap to store the bottom half of numbers
        heapLow = new PriorityQueue<Integer>(Collections.reverseOrder());
        // min heap to store the top half of numbers
        heapHigh = new PriorityQueue<Integer>();
        dataSize = 0;
    }
    
    // @param: the lastest number of the data stream
    // add the most current number from the data stream to the maintainer
    // time complexity O(log i) to obtain the median
    // where i is the real-time number of data points
    public void add(int num) {
        if (dataSize == 0) {
            heapHigh.offer(num);
            // heapLow.offer(n);
        } else if (dataSize % 2 == 0) {
            // balance and add
            if (num > heapHigh.peek()) {
                heapLow.offer(heapHigh.poll());
                heapHigh.offer(num);
            } else {
                heapLow.offer(num);
            }
        } else { // balance and add a current number
            if (num < heapLow.peek()) {
                heapHigh.offer(heapLow.poll());
                heapLow.offer(num);
            } else {
                heapHigh.offer(num);
            }
        }
        // update current data size
        dataSize++;
    }
    
    // @return: the real-time median of the data stream
    public int getMedian() {
        return heapLow.peek();
    }
}
