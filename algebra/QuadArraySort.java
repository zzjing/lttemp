
public class QuadArraySort {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] tranSort = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = -1;
        if (a >= 0) { // graph is upward "U" shape -> maximum toward two ends
            i = nums.length - 1;
        } else { // downward "U" shape -> minimum toward two ends 
            i = 0;
        }
        while (start <= end) {
            int startNum = calculate(nums[start], a, b, c);
            int endNum = calculate(nums[end], a, b, c);
            if (a >= 0) {
                if (startNum >= endNum) {
                    tranSort[i] = startNum;
                    i--;
                    start++;
                } else {
                    tranSort[i] = endNum;
                    i--;
                    end--;
                }
            } else {
                if (startNum >= endNum) {
                    tranSort[i] = endNum;
                    i++;
                    end--;
                } else {
                    tranSort[i] = startNum;
                    i++;
                    start++;
                }
            }
        }
        return tranSort;
    }

    private int calculate(int x, int a, int b, int c) {
        int result = a * x * x + b * x + c;
        return result;
    }
}
