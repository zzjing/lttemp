import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
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
        for (int entry : intersect) {
            intersections[i] = entry;
            i++;
        }
        return intersections;
    }

    public boolean isOneDifference(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        int[] intersec = intersection(word1Arr, word2Arr);
        return (word1.length() - intersec.length == 1) ||
            (word2.length() - intersec.length == 1);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> numToFreq = new HashMap<>();
        List<Integer> intersec = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!numToFreq.containsKey(nums1[i])) {
                numToFreq.put(nums1[i], 1);
            } else {
                numToFreq.put(nums1[i], numToFreq.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (numToFreq.containsKey(nums2[i]) && numToFreq.get(nums2[i]) > 0) {
                intersec.add(nums2[i]);
                numToFreq.put(nums2[i], numToFreq.get(nums2[i]) - 1);
            }
        }
        int[] intersection = new int[intersec.size()];
        for (int i = 0; i < intersec.size(); i++) {
            intersection[i] = intersec.get(i);
        }
        return intersection;
    }
}
