public boolean isMatrixValid(int[][] matrix, int n) {
    for (int i = 0; i < matrix.length; i++) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int rowMin = Integer.MAX_VALUE;
        int rowMax = Integer.MIN_VALUE;
        int colMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            if (!rowSet.contains(matrix[i][j])) {
                rowSet.add(matrix[i][j]);
                rowMin = Math.min(rowMin, matrix[i][j]);
                rowMax = Math.max(rowMax, matrix[i][j]);
            } else {
                return false;
            }
            if (!colSet.contains(matrix[j][i])) {
                colSet.add(matrix[j][i]);
                colMin = Math.min(colMin, matrix[j][i]);
                colMax = Math.max(colMax, matrix[j][i]);
            } else {
                return false;
            }
        }
        if (rowMin != 1 || colMin != 1 || rowMax != n || colMax != n) {
            return false;
        }
    }
    return true;
}

public boolean isValidNonoGram(int[][] matrix, int[][] rowRules, int[][] colRules) {
    int row = matrix.length;
    int col = matrix[0].length;
    if (row != rowRules.length || col != colRules.length) {
        return false;
    }
    return isRowsValid(matrix, rowRules, row, col) && isColsValid(matrix, colRules, row, col);
}

private boolean isRowsValid(int[][] matrix, int[][] rowRules, int row, int col) {
    for (int i = 0; i < row; i++) {
        int rowRuleIndex = 0;
        boolean isEnd = false;
        for (int j = 0; j < col; j++) {
            int cellColor = matrix[i][j];
            if (cellColor = 0) { // black
                if (rowRules.length == 0 || rowRules[i][rowRuleIndex] == 0) {
                    return false;
                }
                rowRules[i][rowRuleIndex]--;
                isEnd = true;
            } else { // white
               if (isEnd) {
                  if (rowRules[i][rowRuleIndex] != 0) {
                      return false;
                  }
                  if (rowRuleIndex < rowRules[i].length) {
                    rowRuleIndex++;
                  }
                  isEnd = false;
               }
            }
        }
        if (rowRuleIndex != rowRuleIndex.length - 1 || rowRules[i][rowRuleIndex] != 0) {
            return false;
        }
    }
    return true;
}

private boolean isColsValid(int[][] matrix, int[][] colRules, int row, int col) {

}