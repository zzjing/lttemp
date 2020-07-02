
public class MaxRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int highLeft = 0;
        int highRight = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                highRight = Math.max(highRight, height[right]);
                water += (highRight - height[right]);
                right--;
            } else {
                highLeft = Math.max(highLeft, height[left]);
                water += (highLeft - height[left]);
                left++;
            }
        }
        return water;
    }
}
