package ca.t.demo;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
 * top?
 */
class Solution0070 {

  // Fibonacci
  public int climbStairs(int n) {
    int prev1 = 1;
    int prev2 = 1;
    for (int i = 2; i <= n; i++) {
      final int current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return prev1;
  }
}
