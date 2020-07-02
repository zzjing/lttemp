import java.util.HashSet;
import java.util.Set;

public class ReflectedLineCheck {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length <= 1) {
            return true;
        }
        Set<String> allPoints = new HashSet<>();
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        for (int[] point : points) {
            xMax = Math.max(xMax, point[0]);
            xMin = Math.min(xMin, point[0]);
            String curPoint = point[0] + "," + point[1];
            allPoints.add(curPoint);
        }
        // sum of x coordinates of a reflected pair of points
        // is a constant: xMax + xMin
        int distance = xMax + xMin;
        for (int[] point : points) {
            int otherX = distance - point[0];
            String otherPoint = otherX + "," + point[1];
            if (!allPoints.contains(otherPoint)) {
                return false;
            }
        }
        return true;
    }
}
