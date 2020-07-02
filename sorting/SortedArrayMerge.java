
public class SortedArrayMerge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int rightOne = m - 1;
        int rightTwo = n - 1;
        int index = m + n - 1;
        while (rightOne >= 0 && rightTwo >= 0) {
            if (nums1[rightOne] > nums2[rightTwo]) {
                nums1[index] = nums1[rightOne];
                index--;
                rightOne--;
            } else {
                nums1[index] = nums2[rightTwo];
                index--;
                rightTwo--;
            }
        }
        while (rightOne >= 0) {
            nums1[index] = nums1[rightOne];
            index--;
            rightOne--;
        }
        while (rightTwo >= 0) {
            nums1[index] = nums2[rightTwo];
            index--;
            rightTwo--;
        }
    }
}
