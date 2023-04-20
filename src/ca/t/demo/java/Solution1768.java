package ca.t.demo.java;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating
 * order, starting with word1. If a string is longer than the other, append the additional letters
 * onto the end of the merged string.
 *
 * <p>Return the merged string.
 */
class Solution1768v1 {
  public String mergeAlternately(String word1, String word2) {
    final int n = Math.min(word1.length(), word2.length());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(word1.charAt(i));
      sb.append(word2.charAt(i));
    }
    return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
  }
}
