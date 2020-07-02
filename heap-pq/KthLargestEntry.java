import java.util.PriorityQueue;

public class KthLargestEntry {
    public int findKthLargest(int[] nums, int k) {
        int kLarge = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0 || k <= 0) {
            return kLarge;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> (b - a));
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            kLarge = pq.poll();
        }
        return kLarge;
    }
}
