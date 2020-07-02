
public class RectOverlapCheck {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null || rec1.length < 4 || rec2.length < 4) {
            return false;
        }
        int btmLeftX = Math.max(rec1[0], rec2[0]);
        int btmLeftY = Math.max(rec1[1], rec2[1]);
        int topRightX = Math.min(rec1[2], rec2[2]);
        int topRightY = Math.min(rec1[3], rec2[3]);
        if (btmLeftX < topRightX && btmLeftY < topRightY) {
            return true;
        }
        return false;
    }
}
