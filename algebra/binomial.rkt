;; #lang racket

;; Compute the binomial coefficients of (n, k);
;; i.e. all combinations of k elements chosen from n.
;; We assume that all inputs are legit.
;; Author: Zezhou Jing, October 3, 2016.

(define (comb n k)
  (/ (factorial n) (* (factorial k) (factorial (- n k)))))

;; Helper method to compute the factorial of a number.
(define (factorial n)
  (if (< n 2)
      1
      (* n (factorial (- n 1)))))
