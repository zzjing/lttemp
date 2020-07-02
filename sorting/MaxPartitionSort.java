
public class MaxPartitionSort {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxChunks = 0;
        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
            // a partition is valid
            // iff a local max can be placed at its respective position
            if (maxVal == i) {
                maxChunks++;
            }
        }
        return maxChunks;
    }

    public int maxChunksToSortedDuplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // store all maxima to the left of the current entry
        // store all minima to the right of the current entry
        // current entry is included in both categories
        int[] maxToLeft = new int[arr.length];
        int[] minToRight = new int[arr.length];
        maxToLeft[0] = arr[0];
        minToRight[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            maxToLeft[i] = Math.max(maxToLeft[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            minToRight[i] = Math.min(minToRight[i + 1], arr[i]);
        }
        // claim: if the current maxToLeft is smaller than or equal to
        // all entries to its right (minToRight), one more partition is found
        int maxChunks = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (maxToLeft[i] <= minToRight[i + 1]) {
                maxChunks++;
            }
        }
        // last entry itself is a chunk: satisfies conditions above
        return maxChunks + 1;
    }

    Stack<Integer> stack = new Stack<Integer>();
        for(int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
                continue;
            }
            int max = stack.peek();
            while(!stack.isEmpty() && stack.peek()> num) {
                stack.pop();
            }
            stack.push(max);
        }
        return stack.size();
}
