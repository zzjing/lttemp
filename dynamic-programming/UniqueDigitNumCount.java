
public class UniqueDigitNumCount {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 10; // 0, 1, 2, 3, 4, ...
        int uniqueDigits = 9;
        int availableNumber = 9;
        // not n >= 1 because 10 numbers for n = 1 is added already
        while (n > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            count += uniqueDigits;
            availableNumber--;
            n--;
        }
        return count;
    }
}
