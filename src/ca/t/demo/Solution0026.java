package ca.t.demo;

/**
 * Remove Duplicates from Sorted Array
 *
 * <p>Array is sorted in non-decreasing order; remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same. Then
 * return the number of unique elements in nums.
 *
 * <p>Change the array nums such that the first k elements of nums contain the unique elements in
 * the order they were present in nums initially. The remaining elements of nums are not important
 * as well as the size of nums.
 */
class Solution0026 {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (final int num : nums) if (i < 1 || num > nums[i - 1]) nums[i++] = num;
    return i;
  }
}
