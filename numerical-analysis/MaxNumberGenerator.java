import java.util.Arrays;
import java.util.Comparator;

public class MaxNumberGenerator {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        // form an array of strings to compare and sort later
        String[] stringNums = new String[nums.length];
        // copy values over to cells of the new array as strings
        for (int i = 0; i < stringNums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        // Comparator to decide which string should come first in concatenation
        Comparator<String> compareString = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // there are only two possible combinations for two strings
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(stringNums, compareString);
        if (stringNums[stringNums.length - 1].charAt(0) == '0') {
            return "0";
        }
        StringBuilder maxNum = new StringBuilder();
        for (int i = stringNums.length - 1; i >= 0; i--) {
            maxNum.append(stringNums[i]);
        }
        return maxNum.toString();
    }
}
