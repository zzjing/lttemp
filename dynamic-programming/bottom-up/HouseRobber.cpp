class HouseRobber {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int robCurrent = 0;
        int notRobCur = 0;
        for (int money : nums) {
            int notRobPrev = notRobCur;
            notRobCur = max(notRobPrev, robCurrent);
            robCurrent = money + notRobPrev;
        }
        return max(robCurrent, notRobCur);
    }

    int robCircle(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums[0];
        }
        return max(robStreet(nums, 0, nums.size() - 2), robCircle(nums, 1, nums.size() - 1));
    }

private:
    int robStreet(vector<int>& nums, int start, int end) {
        int robCurrent = 0;
        int notRobCur = 0;
        for (int i = start; i <= end; i++) {
            int money = nums[i];
            int notRobPrev = notRobCur;
            notRobCur = max(notRobPrev, robCurrent);
            robCurrent = money + notRobPrev;
        }
        return max(robCurrent, notRobCur);
    }
};
