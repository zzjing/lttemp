import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEntry {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // current element x --> next greater element of x
        Map<Integer, Integer> nextElement = new HashMap<Integer, Integer>();
        Stack<Integer> tracker = new Stack<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            // when encounter a greater element than all elements of
            // the previous nondecreasing sequence, mark it
            while (!tracker.isEmpty() && tracker.peek() < nums2[i]) {
                nextElement.put(tracker.pop(), nums2[i]);
            }
            tracker.push(nums2[i]); // put current element into the stack
        }
        int[] nextGreater = new int[nums1.length];
        // output all next elements for the first array
        for (int i = 0; i < nums1.length; i++) {
            if (nextElement.containsKey(nums1[i])) {
                nextGreater[i] = nextElement.get(nums1[i]);
            } else {
                nextGreater[i] = -1;
            }
        }
        return nextGreater;
    }
}
