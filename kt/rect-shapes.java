public List<int[]> findOneRectangle(int[][] board) {
    List<int[]> rectangles = new ArrayList<>();
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (board[i][j] == 0) {
                int x1 = i;
                int y1 = j;
                rectangles.add(new int[]{x1, y1});
                int width = 1;
                int height = 1;
                while (j + width < col && board[i][j] == 0) {
                    width++;
                }
                while (i + height < row && board[i][j] == 0) {
                    height++;
                }
                rectangles.add(new int[][]{i + height - 1, j + width - 1});
                return rectangles;
            }
        }
    }
    return rectangles;
}

public List<List<int[]>> findAllRectangles(int[][] board) {
    List<List<int[]>> rectangles = new ArrayList<>();
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (board[i][j] == 0) {
                int x1 = i;
                int y1 = j;
                List<int[]> rect = new ArrayList<>();
                rect.add(new int[]{x1, y1});
                int width = 1;
                int height = 1;
                while (j + width < col && board[i][j] == 0) {
                    width++;
                }
                while (i + height < row && board[i][j] == 0) {
                    height++;
                }
                for (int h = 0; h < height; h++) {
                    for (int w = 0; w < width; w++) {
                        board[i + h][j + w] = 1;
                    }
                }
                rect.add(new int[][]{i + height - 1, j + width - 1});
                rectangles.add(rect);
            }
        }
    }
    return rectangles;
}

public List<List<int[]>> findAllShapes(int[][] board) {
    List<List<int[]>> allShapes = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 0) {
                List<int[]> shape = new ArrayList<>();
                exploreShape(board, i, j, shape);
                allShapes.add(shape);
            }
        }
    }
    return allShapes;
}

private void exploreShape(int[][] board, int x, int y, List<int[]> shape) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 0) {
        return;
    }
    shape.add(new int[]{{x, y}});
    board[x][y] = 1;
    exploreShape(board, x - 1, y, shape);
    exploreShape(board, x + 1, y, shape);
    exploreShape(board, x, y - 1, shape);
    exploreShape(board, x, y + 1, shape);
}