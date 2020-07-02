import java.util.ArrayList;
import java.util.List;

public class SortedArrayRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftBound = nums[i];
            while (i < nums.length - 1 && (nums[i] == nums[i + 1] - 1)) {
                i++;
            }
            // an "isolated number" as a range
            if (leftBound == nums[i]) {
                ranges.add(leftBound + "");
            } else {
                ranges.add(leftBound + "->" + nums[i]);
            }
        }
        return ranges;
    }
}