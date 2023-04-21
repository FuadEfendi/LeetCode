package ca.t.demo

object Solution0066s {
  
  // Scala approach
  def plusOne7(digits: Array[Int]): Array[Int] = {
    val (ret, inc) = digits.foldRight((Array.empty[Int], true)) {
      case (d, (acc, false)) => (d +: acc, false)
      case (d, (acc, true)) if d == 9 => (0 +: acc, true)
      case (d, (acc, true)) => ((d + 1) +: acc, false)
    }
    if (inc) 1 +: ret
    else ret
    /* note that removing `else` is wrong: expression being calculated but not assigned to the return:
     if (inc) 1 +: ret
     ret
     */
  }

  // Java-like approach
  def plusOne2(digits: Array[Int]): Array[Int] = {
    for (i <- digits.length - 1 to 0 by -1) {
      if (digits(i) < 9) {
        digits(i) += 1
        return digits
      }
      digits(i) = 0
    }
    1 +: digits
  }

}
