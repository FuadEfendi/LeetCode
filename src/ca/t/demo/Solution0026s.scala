package ca.t.demo

object Solution0026s {
  def removeDuplicates(nums: Array[Int]): Int = {
    val resultingArray = nums.distinct
    resultingArray.zipWithIndex.foreach { case (item, index) => nums(index) = item }
    resultingArray.length
  }
}
