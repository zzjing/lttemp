import java.util.LinkedList;
import java.util.List;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int majority = nums[0];
        int diffCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                diffCount++;
            } else if (count == 0) {
                majority = nums[i];
                diffCount = 1;
            } else { // count != 0
                diffCount--;
            }
        }
        return majority;
    }

    public List<Integer> getMajorityElements(int[] nums) {
        List<Integer> majorities = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return majorities;
        }
        int major1 = nums[0];
        int major2 = nums[0];
        int diffCount1 = 0;
        int diffCount2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major1) {
                diffCount1++;
            } else if (nums[i] == major2) {
                diffCount2++;
            } else if (count1 == 0) {
                major1 = nums[i];
                diffCount1 = 1;
            } else if (count2 == 0) {
                major2 = nums[i];
                diffCount2 = 1;
            } else {
                diffCount1--;
                diffCount2--;
            }
        }
        diffCount1 = 0; // counters may not be correct
        diffCount2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major1) {
                diffCount1++;
            } else if (nums[i] == major2) {
                diffCount2++;
            }
        }   
        if (diffCount1 > nums.length / 3) {
            majorities.add(major1);
        }
        if (diffCount2 > nums.length / 3) {
            majorities.add(major2);
        }
        return majorities;
    }
}
