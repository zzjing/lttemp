class CombinationSum {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> combSet;
        if (candidates.size() == 0) {
            return combSet;
        }
        vector<int> combination;
        getCombination(candidates, target, 0, combSet, combination);
        return combSet;
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> combSet;
        if (candidates.size() == 0) {
            return combSet;
        }
        sort(candidates.begin(), candidates.end());
        vector<int> combination;
        noReuseCombination(candidates, target, 0, combSet, combination);
        return combSet;
    }

private:
    void getCombination(vector<int>& candidates, int target, int startPos,
        vector<vector<int>>& combSet, vector<int>& combination) {
        if (target == 0) {
            combSet.push_back(combination);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startPos; i < candidates.size(); i++) {
            combination.push_back(candidates[i]);
            getCombination(candidates, target - candidates[i], i, combSet, combination);
            combination.pop_back();
        }
    }

    void noReuseCombination(vector<int>& candidates, int target, int startPos,
        vector<vector<int>>& combSet, vector<int>& combination) {
        if (target == 0) {
            combSet.push_back(combination);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startPos; i < candidates.size(); i++) {
            if (i != startPos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.push_back(candidates[i]);
            noReuseCombination(candidates, target - candidates[i], i + 1, combSet, combination);
            combination.pop_back();
        }
    }
};
