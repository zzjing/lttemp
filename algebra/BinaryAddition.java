
public class BinaryAddition {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int digitSum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                digitSum += (a.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                digitSum += (b.charAt(j) - '0');
                j--;
            }
            sb.append(digitSum % 2);
            digitSum /= 2;
        }
        if (digitSum != 0) {
            sb.append(digitSum);
        }
        return sb.reverse().toString();
    }
}
