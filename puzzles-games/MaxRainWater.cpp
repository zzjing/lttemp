
class MaxRainWater {
public:
    int trap(vector<int>& height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;
        int highestLeft = 0;
        int highestRight = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                highestRight = max(highestRight, height[right]);
                maxWater += (highestRight - height[right]);
                right--;
            } else {
                highestLeft = max(highestLeft, height[left]);
                maxWater += (highestLeft - height[left]);
                left++;
            }
        }
        return maxWater;
    }
};
