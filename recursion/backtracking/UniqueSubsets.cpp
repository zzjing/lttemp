class UniqueSubsets {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subsets;
        if (nums.size() == 0) {
            return subsets;
        }
        vector<int> oneSet;
        getSubsets(nums, 0, subsets, oneSet);
        return subsets;
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> subsets;
        if (nums.size() == 0) {
            return subsets;
        }
        sort(nums.begin(), nums.end());
        vector<int> oneSet;
        getSubsetsWithDup(nums, 0, subsets, oneSet);
        return subsets;
    }

private:
    void getSubsets(vector<int>& nums, int startPos,
        vector<vector<int>>& subsets, vector<int>& oneSet) {
        subsets.push_back(oneSet);
        for (int i = startPos; i < nums.size(); i++) {
            oneSet.push_back(nums[i]);
            getSubsets(nums, i + 1, subsets, oneSet);
            oneSet.pop_back();
        }
    }

    void getSubsetsWithDup(vector<int>& nums, int startPos,
        vector<vector<int>>& subsets, vector<int>& oneSet) {
        subsets.push_back(oneSet);
        for (int i = startPos; i < nums.size(); i++) {
            if (i != startPos && nums[i] == nums[i - 1]) {
                continue;
            }
            oneSet.push_back(nums[i]);
            getSubsetsWithDup(nums, i + 1, subsets, oneSet);
            oneSet.pop_back();
        }
    }
};
