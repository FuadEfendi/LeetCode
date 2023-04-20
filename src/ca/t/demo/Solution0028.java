package ca.t.demo;

class Solution0028 {
  public int strStr(String haystack, String needle) {
    final int h = haystack.length();
    final int n = needle.length();
    for (int i = 0; i < h - n + 1; ++i) if (haystack.substring(i, i + n).equals(needle)) return i;
    return -1;
  }
  public int strStr2(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

}
