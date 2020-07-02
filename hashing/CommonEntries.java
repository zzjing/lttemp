import java.util.HashSet;
import java.util.Set;

public class CommonEntries {
    public int[] commonEntries(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] intersections = new int[intersect.size()];
        int i = 0;
        for (Integer entry : intersect) {
            intersections[i] = entry;
            i++;
        }
        return intersections;
    }
}