Useful identities:

To obtain the last digit of an integer n (from left side) in Java, mod n by 10. In other words, the remainder of an integer divided by 10 is its last digit.

Example.
            10243 % 10 = 3.
          
To obtain the first digit of an integer n in Java, we first introduce a divisor variable, denoted by d. It is defined as follows:
            d = 10 ^ (number of digits of n - 1).

Then the first digit of n is n / d, the integer part of n / d, say int(n / d).

Example.
            d(10243) = 10^4 = 10000;
            10243 / 10000 = 1.

To eliminate the first digit (and all succeding zero digits) of an integer n, mod it by d.

Example.
            10234 % 10000 = 234.
            98756 % 10000 = 8756.
     
To eliminate the last digit of an integer n, divide it by 10.

Example.
            10243 / 10 = 1024.
