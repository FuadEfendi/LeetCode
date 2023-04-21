package ca.t.demo;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * <p>You must not use any built-in exponent function or operator.
 */
class Solution0069 {
  public int mySqrt(int x) {
    long left = 1;
    long right = x + 1L; // prevent overflow of Integer; use 'long'
    while (left < right) {
      final long middle = (left + right) / 2;
      if (middle * middle > x) right = middle;
      else left = middle + 1;
    }
    return (int) left - 1;
  }
}
