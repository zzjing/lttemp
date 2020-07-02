
public class PowerOfThreeCheck {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is the largest power of three possible in Java
        return n > 0 && (1162261467 % n == 0);
    }
}
