
public class SingletonSearch {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            // The first element of the middle pair,
            // must be at an even index if the left part is sorted.
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            // The single element must be on the left if a pair isn't found
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6|
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                // The single element must be on the right if a pair is found.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:    |1 1 3 3|5 6 6|
                start = mid + 2; // skip the current pair
            }
        }
        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];
    }
}
