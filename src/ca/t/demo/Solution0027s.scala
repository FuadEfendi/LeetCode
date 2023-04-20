package ca.t.demo

object Solution0027s {

  // best Scala syntax
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    val result = nums.filter(_ != `val`)
    result.indices.foldLeft(nums) { (nums, i) =>
      nums(i) = result(i)
      nums
    }
    result.length
  }

  def removeElement2(nums: Array[Int], `val`: Int): Int = {
    val result = nums.filter(_ != `val`)
    for (i <- 0 to result.length - 1) {
      nums(i) = result(i)
    }
    result.length
  }

}
