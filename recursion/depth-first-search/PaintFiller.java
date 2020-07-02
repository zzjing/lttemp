/**
 * Fills the surrounding area of a designated point
 * with some color.
 * 
 * @author Zezhou Jing, University of Washington
 * @date October 3, 2016
 */

public class PaintFiller {
    // @param area: area to be painted
    // @param x, y: coordinate to start with
    // @param desiredFill: indicator for filling
    public void fillBucket(boolean[][] area, int x, int y, boolean desiredFill) {
        // do nothing if the origin is illegal
        if (x < 0 || x >= area.length || y < 0 || y >= area[0].length) {
            return;
        }
        if (area[x][y] != desiredFill) {
            // fill each point of the area
            area[x][y] = desiredFill;
            // go around the point
            fillBucket(area, x - 1, y, desiredFill);
            fillBucket(area, x + 1, y, desiredFill);
            fillBucket(area, x, y - 1, desiredFill);
            fillBucket(area, x, y + 1, desiredFill);
        }
    }
}
