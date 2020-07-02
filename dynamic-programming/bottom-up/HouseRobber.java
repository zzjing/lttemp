
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 0 - does not rob the current house; 1 - rob
        int[][] gain = new int[nums.length + 1][2];
        for (int i = 1; i < nums.length + 1; i++) {
            // not to rob the current house
            gain[i][0] = Math.max(gain[i - 1][0], gain[i - 1][1]);
            // note the length difference, current stash is nums[i - 1]
            gain[i][1] = nums[i - 1] + gain[i - 1][0];
        }
        return Math.max(gain[nums.length][0], gain[nums.length][1]);
    }

    public int robHouse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int robHouse = 0;
        int notRobHouse = 0;
        for (int money : nums) {
            int notRobPrevHouse = notRobHouse;
            notRobHouse = Math.max(notRobPrevHouse, robHouse);
            robHouse = money + notRobPrevHouse;
        }
        return Math.max(robHouse, notRobHouse);
    }

    public int robCircle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // to break the circle, choose not to rob either last or first house
        // Math.max(robFirst-spareLast, robLast-spareFirst)
        return Math.max(robStreet(nums, 0, nums.length - 2),
                robStreet(nums, 1, nums.length - 1));
    }

    private int robStreet(int[] nums, int start, int end) {
        int robHouse = 0;
        int notRobHouse = 0;
        for (int i = start; i <= end; i++) {
            int notRobPrev = notRobHouse;
            notRobHouse = Math.max(notRobPrev, robHouse);
            robHouse = nums[i] + notRobPrev;
        }
        return Math.max(robHouse, notRobHouse);
    }
}
