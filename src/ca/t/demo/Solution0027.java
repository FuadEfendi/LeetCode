package ca.t.demo;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are
 * not equal to val.
 */
class Solution0027 {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (final int num : nums) if (num != val) nums[i++] = num;
    return i;
  }
}
