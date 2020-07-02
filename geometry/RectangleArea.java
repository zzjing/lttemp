
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);
        int rectArea1 = (C - A) * (D - B);
        int rectArea2 = (G - E) * (H - F);
        int overlapArea = (right - left) * (top - bottom);
        return rectArea1 + rectArea2 - overlapArea;
    }
}
