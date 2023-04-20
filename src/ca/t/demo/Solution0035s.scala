package ca.t.demo

import scala.annotation.tailrec

object Solution0035s {

  def main(args: Array[String]): Unit = {
    //testing with array of size 10000
    val arr = (1 to 10000).map(_ => scala.util.Random.nextInt(50000)).sorted.distinct.toArray

    val v1 = measureExecutionTime {
      searchInsert1(arr, 100)
      searchInsert1(arr, 1000)
      searchInsert1(arr, 10000)
      searchInsert1(arr, 20000)
      searchInsert1(arr, 25000)
    }

    val v2 = measureExecutionTime {
      searchInsert2(arr, 100)
      searchInsert2(arr, 1000)
      searchInsert2(arr, 10000)
      searchInsert2(arr, 20000)
      searchInsert2(arr, 25000)
    }

    val v3 = measureExecutionTime {
      searchInsert3(arr, 100)
      searchInsert3(arr, 1000)
      searchInsert3(arr, 10000)
      searchInsert3(arr, 20000)
      searchInsert3(arr, 25000)
    }

    val v4 = measureExecutionTime {
      searchInsert4(arr, 100)
      searchInsert4(arr, 1000)
      searchInsert4(arr, 10000)
      searchInsert4(arr, 20000)
      searchInsert4(arr, 25000)
    }

  }

  def searchInsert1(nums: Array[Int], target: Int): Int =
    if (nums contains target) nums indexOf target else nums.length - nums.dropWhile(target >= _).length

  def searchInsert2(nums: Array[Int], target: Int): Int = {
    var (low, high) = (0, nums.length - 1)
    while (low <= high) {
      val mid = (low + high) / 2
      if (target == nums(mid)) return mid
      else if (target > nums(mid)) low = mid + 1 else high = mid - 1
    }
    low
  }

  def searchInsert3(nums: Array[Int], target: Int): Int = {
    var (low, high) = (0, nums.length - 1)
    while (low <= high) {
      val mid = (low + high) / 2
      nums(mid) match {
        case i if i == target => return mid
        case i if target > i => low = mid + 1
        case _ => high = mid - 1
      }
    }
    low
  }

  def searchInsert4(nums: Array[Int], target: Int): Int = {
    @tailrec
    def helper(start: Int, end: Int): Int = {
      if (start > end) return start
      val mid = (start + end) / 2
      nums(mid) match {
        case i if i == target => return mid
        case i if target > i => helper(mid + 1, end)
        case _ => helper(start, mid - 1)
      }
    }

    helper(0, nums.length - 1)
  }

  /**
   * Executes some code block and prints to stdout the time taken to execute the block. This is
   * available in Scala only and is used primarily for interactive testing and debugging.
   */
  def measureExecutionTime[T](f: => Unit): Unit = {

    /**
     * JIT compiles bytecode to native machine code to optimize efficiency.
     * JVM interprets the same sequence of bytecode repeatedly and incurs a longer execution time.
     * The hardware executes the native code of repeated method calls.
     */
    1 to 10000 foreach { _ => f }

    val start = System.nanoTime()
    1 to 1000 foreach { _ => f }
    val end = System.nanoTime()

    println(s"Average time taken: ${(end - start) / 1000 / 5} nanoseconds")

  }
}
