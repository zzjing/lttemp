import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AmbigramGenerator {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        } else if (num.charAt(0) == '-') {
            return false;
        }
        // 0 -> 0; 1 -> 1; 6 -> 9; 8 -> 8; 9 -> 6
        Map<Character, Character> charToRotation = new HashMap<>();
        charToRotation.put('0', '0');
        charToRotation.put('1', '1');
        charToRotation.put('6', '9');
        charToRotation.put('8', '8');
        charToRotation.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char curLeft = num.charAt(left);
            char curRight = num.charAt(right);
            if (charToRotation.containsKey(curLeft)) {
                if (charToRotation.get(curLeft) != curRight) {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return findStrobogrammatic(n, n);
    }
    // expand around the center via recursion
    private List<String> findStrobogrammatic(int curLen, int prevLen) {
        if (curLen == 0) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        if (curLen == 1) {
            List<String> singleDig = new ArrayList<>();
            singleDig.add("0");
            singleDig.add("1");
            singleDig.add("8");
            return singleDig;
        }
        List<String> subNumbers = findStrobogrammatic(curLen - 2, prevLen);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < subNumbers.size(); i++) {
            String subNum = subNumbers.get(i);
            // expand two "0"s around the original except for top level of recursion
            if (curLen != prevLen) {
                numbers.add("0" + subNum + "0");
            }
            numbers.add("1" + subNum + "1");
            numbers.add("6" + subNum + "9");
            numbers.add("8" + subNum + "8");
            numbers.add("9" + subNum + "6");
        }
        return numbers;
    }
}
