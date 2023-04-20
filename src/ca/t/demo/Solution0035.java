package ca.t.demo;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 *
 * <p>You must write an algorithm with O(log n) runtime complexity.
 */
class Solution0035 {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      final int middle = (left + right) / 2;
      if (nums[middle] == target) return middle;
      if (nums[middle] < target) left = middle + 1;
      else right = middle;
    }
    return left;
  }
}
