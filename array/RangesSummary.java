import java.util.LinkedList;
import java.util.List;

public class RangesSummary {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftBound = nums[i];
            // check consecutiveness
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            // nums[i] is an isolated value as a range
            if (leftBound == nums[i]) {
                ranges.add(leftBound + "");
            } else {
                ranges.add(leftBound + "->" + nums[i]);
            }
        }
        return ranges;
    }
}
