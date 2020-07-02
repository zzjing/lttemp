class SortedMatrixSearch {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return false;
        }
        int curRow = 0;
        int curCol = matrix[0].size() - 1;
        while (curRow < matrix.size() && curCol >= 0) {
            int curEntry = matrix[curRow][curCol];
            if (curEntry == target) {
                return true;
            }
            if (curEntry > target) {
                curCol--;
            } else {
                curRow++;
            }
        }
        return false;
    }
};
