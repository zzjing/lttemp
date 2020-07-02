class ValidParenGenerator {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> validPairs;
        if (n <= 0) {
            return validPairs;
        }
        string curParen = "";
        getValidPairs(n, n, validPairs, curParen);
        return validPairs;
    }

private:
    void getValidPairs(int leftBraces, int rightBraces,
        vector<string>& validPairs, string& curParen) {
        if (leftBraces == 0 && rightBraces == 0) {
            validPairs.push_back(curParen);
            return;
        }
        if (leftBraces > 0) {
            curParen += '(';
            getValidPairs(leftBraces - 1, rightBraces, validPairs, curParen);
            curParen.pop_back();
        }
        if (rightBraces > leftBraces) {
            curParen += ')';
            getValidPairs(leftBraces, rightBraces - 1, validPairs, curParen);
            curParen.pop_back();
        }
    }
};
