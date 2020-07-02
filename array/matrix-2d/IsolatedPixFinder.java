
public class IsolatedPixFinder {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0) {
            return 0;
        }
        int[] rowCount = new int[picture.length];
        int[] colCount = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int lonelyPix = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    lonelyPix++;
                }
            }
        }
        return lonelyPix;
    }
}
