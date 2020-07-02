
public class PowerOfFourChecker {
    public boolean isPowerOfFour(int num) {
        // 0x55555555 rules out power of 2 but not power of 4
        // this way, the single 1 bit always appears at the odd position
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}
