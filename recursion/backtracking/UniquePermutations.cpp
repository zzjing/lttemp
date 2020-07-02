class UniquePermutations {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> permutations;
        if (nums.size() == 0) {
            return permutations;
        }
        vector<int> onePerm;
        getPermutation(nums, permutations, onePerm);
        return permutations;
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> permutations;
        if (nums.size() == 0) {
            return permutations;
        }
        sort(nums.begin(), nums.end());
        vector<bool> used(nums.size());
        vector<int> onePerm;
        getPermutationUnique(nums, used, permutations, onePerm);
        return permutations;
    }

private:
    void getPermutation(vector<int>& nums, vector<vector<int>>& permutations, vector<int>& onePerm) {
        if (onePerm.size() == nums.size()) {
            permutations.push_back(onePerm);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (find(onePerm.begin(), onePerm.end(), nums[i]) != onePerm.end()) {
                continue;
            }
            onePerm.push_back(nums[i]);
            getPermutation(nums, permutations, onePerm);
            onePerm.pop_back();
        }
    }

    void getPermutationUnique(vector<int>& nums, vector<bool>& used,
        vector<vector<int>>& permutations, vector<int>& onePerm) {
        if (onePerm.size() == nums.size()) {
            permutations.push_back(onePerm);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && (!used[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            onePerm.push_back(nums[i]);
            used[i] = true;
            getPermutationUnique(nums, used, permutations, onePerm);
            onePerm.pop_back();
            used[i] = false;
        }
    }
};
