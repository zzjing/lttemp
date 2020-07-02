
public class ThirdMaxValue {
    // O(kn) time, O(1) space
    public int thirdMax(int[] nums) {
        Integer maxVal = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for (Integer n : nums) {
            if (n.equals(maxVal) || n.equals(secondMax) || n.equals(thirdMax)) {
                continue;
            }
            if (maxVal == null || n > maxVal) {
                thirdMax = secondMax;
                secondMax = maxVal;
                maxVal = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }
        if (thirdMax == null) {
            return maxVal;
        }
        return thirdMax;
    }
}
