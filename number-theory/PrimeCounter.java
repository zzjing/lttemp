/**
 * Count the number of prime numbers within a given range.
 *
 * @author Zezhou Jing, University of Washington
 * @date October 16, 2016
 */
import java.util.Arrays;

public class PrimeCounter {
    // @param n: maximum range of numbers in which primes are counted
    // @return: number of primes within that range
    // Sieve of Eratosthenes method; Time complexity O(n loglog n), space O(n)
    public int countPrimes(int n) {
        int primeCount = 0;
        boolean[] primeList = new boolean[n];
        Arrays.fill(primeList, true);
        // note 1 is not a prime
        for (int i = 2; i < n; i++) {
            if (primeList[i]) {
                // a number times a even number never results a prime
                for (int j = i * 2; j < n; j += i) {
                    primeList[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (primeList[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
