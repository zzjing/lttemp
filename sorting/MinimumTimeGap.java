import java.util.Arrays;
import java.util.List;

public class MinimumTimeGap {
    public int findMinDifference(List<String> timePoints) {
        int totSec = 24 * 3600;
        int[] timeInSec = new int [timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String timeStr = timePoints.get(i);
            String[] hrMin = timeStr.split(":");
            int hr = Integer.parseInt(hrMin[0]);
            int min = Integer.parseInt(hrMin[1]);
            int sec = hr * 3600 + min * 60;
            timeInSec[i] = sec;
        }
        Arrays.sort(timeInSec);
        int minDiff = totSec;
        for (int i = 0; i < timeInSec.length - 1; i++) {
            int diff1 = Math.abs(timeInSec[i] - timeInSec[i + 1]);
            int diff2 = totSec - diff1;
            int currentMin = Math.min(diff1, diff2);
            // update
            minDiff = Math.min(currentMin, minDiff);
        }
        int last1 = Math.abs(timeInSec[timeInSec.length - 1] - timeInSec[0]);
        int last2 = totSec- last1;
        int lastMin = Math.min(last1, last2);
        minDiff = Math.min(lastMin, minDiff);
        return minDiff / 60;
    }
}
