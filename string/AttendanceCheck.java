
public class AttendanceCheck {
    public boolean checkRecord(String s) {
        boolean absence = false;
        int contLate = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (absence) {
                    return false;
                }
                absence = true;
            }
            if (s.charAt(i) != 'L' && contLate > 0) {
                contLate = 0;
            }
            if (s.charAt(i) == 'L') {
                contLate++;
            }
            if (contLate == 3) {
                return false;
            }
        }
        return true;
    }
}
