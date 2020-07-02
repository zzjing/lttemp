import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterTracker {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2 == null || nums1.length > nums2.length) {
            return new int[0];
        }
        // current element x --> next greater element of x
        Map<Integer, Integer> numToGreater = new HashMap<>();
        Stack<Integer> seqTracker = new Stack<>();
        for (int current : nums2) {
            // when encounter a greater element than all elements of
            // the (nondecreasing) sequence, mark it
            while (!seqTracker.isEmpty() && seqTracker.peek() < current) {
                numToGreater.put(seqTracker.peek(), current);
                seqTracker.pop();
            }
            seqTracker.push(current);
        }
        int[] nextGreater = new int[nums1.length];
        // output all next elements for the first array
        for (int i = 0; i < nextGreater.length; i++) {
            if (numToGreater.containsKey(nums1[i])) {
                nextGreater[i] = numToGreater.get(nums1[i]);
            } else {
                nextGreater[i] = -1;
            }
        }
        return nextGreater;
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> indices = new Stack<>();
        // scan the array twice to find
        // the next greater element for every entry
        for (int i = 0; i < nums.length * 2; i++) {
            // index of the circular array structure
            int j = i % nums.length;
            while (!indices.isEmpty() && nums[indices.peek()] < nums[j]) {
                nextGreater[indices.pop()] = nums[j];
            }
            // save indices of the decreasing subsequence
            indices.push(j);
        }
        return nextGreater;
    }
}
