
public class FloodFiller {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0) {
            return new int[0][0];
        }
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            floodFill(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

    private void floodFill(int[][] image, int i, int j, int newColor, int oldColor) {
        if (i < 0 || i >= image.length ||
            j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        floodFill(image, i + 1, j, newColor, oldColor);
        floodFill(image, i - 1, j, newColor, oldColor);
        floodFill(image, i, j + 1, newColor, oldColor);
        floodFill(image, i, j - 1, newColor, oldColor);
        // no backtracking because we only expand along four connected directions for each pixel
    }
}
