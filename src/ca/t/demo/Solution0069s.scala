package ca.t.demo


object Solution0069s {

  // binary search
  def mySqrt(x: Int): Int = {
    var low = 1L
    var high = x + 1L
    while (low <= high) {
      var middle = (low + high) / 2
      if (middle * middle > x) high = middle - 1
      else low = middle + 1
    }
    (low - 1).toInt
  }

}
