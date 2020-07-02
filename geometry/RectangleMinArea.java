
public class RectangleMinArea {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length < 4) {
            return -1;
        }
        int minArea = Integer.MAX_VALUE;
        Set<String> codedPoints = new HashSet<>();
        for (int[] pt : points) {
            String point = pt[0] + "," + pt[1];
            codedPoints.add(point);
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (codedPoints.contains((points[i][0] + "," + points[j][1]))
                        && codedPoints.contains((points[j][0] + "," + points[i][1]))) {
                        minArea = Math.min(minArea, (Math.abs(points[i][0] - points[j][0])
                            * Math.abs(points[i][1] - points[j][1])));
                    }
                }
            }
        }
        if (minArea < Integer.MAX_VALUE) {
            return minArea;
        }
        return 0;
    }
}
