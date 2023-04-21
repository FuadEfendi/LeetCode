package ca.t.demo


object Solution0070s {

  // fastest!
  @scala.annotation.tailrec
  def climbStairs(n: Int, dp0: Int = 1, dp1: Int = 1): Int = {
    if (n > 1) climbStairs(n - 1, dp1, dp0 + dp1)
    else dp1
  }

  // slower
  def climbStairs(n: Int): Int = {
    (1 to n).foldLeft((0, 1)) { case ((a, b), _) => (b, a + b) }._2
  }

  // @tailrec
  // super slow, cannot be optimized!
  def climbStairs2(n: Int): Int = {
    if (n < 0) 0 else if (n == 0) 1 else climbStairs(n - 1) + climbStairs(n - 2)
  }
  
}
