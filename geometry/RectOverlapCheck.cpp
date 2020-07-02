class RectOverlapCheck {
public:
    bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        if (rec1.size() < 4 || rec2.size() < 4) {
            return false;
        }
        int btmLeftX = max(rec1[0], rec2[0]);
        int btmLeftY = max(rec1[1], rec2[1]);
        int topRightX = min(rec1[2], rec2[2]);
        int topRightY = min(rec1[3], rec2[3]);
        if (btmLeftX < topRightX && btmLeftY < topRightY) {
            return true;
        }
        return false;
    }
};
