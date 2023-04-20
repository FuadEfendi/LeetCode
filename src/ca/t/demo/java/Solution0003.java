package ca.t.demo.java;

import java.util.Arrays;

/**
 * 3. Longest Substring Without Repeating Characters<br>
 * Given a string s, find the length of the longest substring without repeating characters.<br>
 * Constraints:
 *
 * <p>0 <= s.length <= 50000<br>
 * s consists of English letters, digits, symbols and spaces.
 */
// Approach 1: Sliding window
class Solution0003 {
  public int lengthOfLongestSubstring(String s) {
    int ret = 0;
    int[] count = new int[128];
    for (int l = 0, r = 0; r < s.length(); r++) {
      count[s.charAt(r)]++;
      while (count[s.charAt(r)] > 1) --count[s.charAt(l++)];
      ret = Math.max(ret, r - l + 1);
    }
    return ret;
  }
}

// Approach 2: Last seen
class Solution0003_2 {
  public int lengthOfLongestSubstring(String s) {
    int ret = 0;
    int j = -1; // s[j + 1..i] has no repeating chars.
    int[] lastSeen = new int[128]; // lastSeen[c] := index of last c appeared.
    Arrays.fill(lastSeen, -1);
    for (int i = 0; i < s.length(); ++i) {
      // Update j to lastSeen[c], so the window must start from j + 1.
      j = Math.max(j, lastSeen[s.charAt(i)]);
      ret = Math.max(ret, i - j);
      lastSeen[s.charAt(i)] = i;
    }
    return ret;
  }
}
