import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueListElements {
    public List<List<Integer>> getUniqueElements(int[] nums1, int[] nums2) {
        List<List<Integer>> uniques = new ArrayList<>();
        Map<Integer, Integer> numToFreq = new HashMap<>();
        List<Integer> list1Unique = new ArrayList<>();
        List<Integer> list2Unique = new ArrayList<>();
        for (int num : nums1) {
            if (!numToFreq.containsKey(num)) {
                numToFreq.put(num, 1);
            } else {
                numToFreq.put(num, numToFreq.get(num) + 1);
            }
        }
        for (int num : nums2) {
            if (!numToFreq.containsKey(num)) {
                list2Unique.add(num);
            } else {
                numToFreq.put(num, numToFreq.get(num) - 1);
                if (numToFreq.get(num) == 0) {
                    numToFreq.remove(num);
                }
            }
        }
        for (int num : numToFreq.keySet()) {
            list1Unique.add(num);
        }
        uniques.add(list1Unique);
        uniques.add(list2Unique);
        return uniques;
    }
}
