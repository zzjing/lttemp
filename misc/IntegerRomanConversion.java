/**
 * Convert an integer between 1 and 3999 to the corresponding Roman number.
 * 
 * @author Zezhou Jing, University of Washington
 * @date October 22, 2016
 * 
 */

import java.util.Map;
import java.util.HashMap;

public class IntegerRomanConversion {
    // Hash table solution
    // @param n: an integer between 1 and 3999
    // @return: the corresponding Roman number as a string
    public String intToRoman(int n) {
        if (n <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symb = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        int digit = 0;
        while (n != 0) {
            // figure out how many symbols
            int countSymbols = n / nums[digit];
            // subtract and append such symbols
            n -= nums[digit] * countSymbols;
            while (countSymbols > 0) {
                roman.append(symb[digit]);
                countSymbols--;
            }
            // move from the highest digit representation to lower ones
            digit++;
        }
        return roman.toString();
    }

    // @param s: the string representation of a Roman number 
    // @return: the corresponding integer
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> romanInt = new HashMap<Character, Integer>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);

        int length = s.length();
        int number = romanInt.get(s.charAt(length - 1));
        // i + 1: "last" roman digit, i: the digit before and also current digit
        for (int i = length - 2; i >= 0; i--) {
            if (romanInt.get(s.charAt(i + 1)) <= romanInt.get(s.charAt(i))) {
                number += romanInt.get(s.charAt(i));
            } else {
                number -= romanInt.get(s.charAt(i));
            }
        }
        return number;
    }
}
