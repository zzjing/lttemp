

public class MaxHistogramArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int barMinHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                barMinHeight = Math.min(barMinHeight, heights[j]);
                maxArea = Math.max(maxArea, barMinHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
