;; #lang racket

;; Compute the factorial of a nonnegative number n as (n!).
;; Author: Zezhou Jing, October 3, 2016.

(define (factorial n)
  (if (< n 2)
      1
      (* n (factorial (- n 1)))))
