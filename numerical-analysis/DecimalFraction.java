import java.util.HashMap;
import java.util.Map;

public class DecimalFraction {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fractioned = new StringBuilder();
        String sign = "";
        if (numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0) {
            sign = "";
        } else {
            sign = "-";
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        fractioned.append(sign);
        fractioned.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return fractioned.toString();
        }
        fractioned.append(".");
        Map<Long, Integer> decimals = new HashMap<Long, Integer>();
        while (!decimals.containsKey(remainder)) {
            decimals.put(remainder, fractioned.length());
            fractioned.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = decimals.get(remainder);
        fractioned.insert(index, "(");
        fractioned.append(")");
        return fractioned.toString().replace("(0)", "");
    }
}
