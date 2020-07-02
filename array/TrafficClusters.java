import java.util.ArrayList;
import java.util.List;

public class TrafficClusters {
    public List<List<Integer>> getClusters(int[] speeds) {
        if (speeds == null || speeds.length <= 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> roadClusters = new ArrayList<>();
        roadClusters.add(new ArrayList<>());
        int slowest = Integer.MAX_VALUE;
        for (int i = 0; i < speeds.length; i++) {
            int curSpeed = speeds[i];
            List<Integer> lastCluster = roadClusters.get(roadClusters.size() - 1);
            if (curSpeed < slowest) {
                if (lastCluster.size() == 0) {
                    lastCluster.add(curSpeed);
                    slowest = Math.min(slowest, curSpeed);
                } else {
                    lastCluster.add(curSpeed);
                    if (i != speeds.length - 1) {
                        roadClusters.add(new ArrayList<>());
                    }
                }
            } else {
                lastCluster.add(curSpeed);
            }
        }
        return roadClusters;
    }

    public List<Integer> getClusterSizes(int[] speeds) {
        if (speeds == null || speeds.length <= 1) {
            return new ArrayList<>();
        }
        int slowest = Integer.MAX_VALUE;
        int lastClusterSize = 1;
        List<Integer> roadSizes = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            int curSpeed = speeds[i];
            if (curSpeed < slowest) {
                if (i != 0) {
                    roadSizes.add(lastClusterSize);
                    if (i == speeds.length - 1) {
                        roadSizes.add(1);
                    } else {
                        lastClusterSize = 1;
                    }
                }
                slowest = Math.min(slowest, curSpeed);
            } else {
                lastClusterSize++;
            }
        }
        return roadSizes;
    }

    public int countClusters(int[] speeds) {
        List<Integer> roadSizes = getClusterSizes(speeds);
        return roadSizes.size();
    }

    public List<List<Integer>> addMaxSpeed(int[] speeds) {
        if (speeds == null || speeds.length <= 1) {
            return new ArrayList<>();
        }
        List<Integer> clusterSizes = getClusterSizes(speeds);
        List<List<Integer>> newSizes = new ArrayList<>();
        newSizes.add(new ArrayList<>(clusterSizes));
        newSizes.get(0).add(0, 1);
        for (int i = 0; i < clusterSizes.size(); i++) {
            newSizes.add(new ArrayList<>(clusterSizes));
            List<Integer> oldSizes = newSizes.get(i + 1);
            int newSize = oldSizes.get(i) + 1;
            oldSizes.set(i, newSize);
        }
        return newSizes;
    }
}
