
class MatrixTranspose {
public:
    vector<vector<int>> transpose(vector<vector<int>>& A) {
        if (A.size() == 0 || A[0].size() == 0) {
            return A;
        }
        vector<vector<int>> transpose(A[0].size(), vector<int>(A.size()));
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A[0].size(); j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }
};
