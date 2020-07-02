
public class RotationValidator {
    public int rotatedDigits(int N) {
        if (N <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isNumberValid(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isNumberValid(int num) {
        boolean valid = false;
        while (num > 0) {
            int lastDig = num % 10;
            if (lastDig == 2 || lastDig == 5 || lastDig == 6 || lastDig == 9) {
                valid = true;
            }
            if (lastDig == 3 || lastDig == 4 || lastDig == 7) {
                return false;
            }
            num /= 10;
        }
        return valid;
    }
}
