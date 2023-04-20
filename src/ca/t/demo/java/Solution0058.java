package ca.t.demo.java;

class Solution0058v1 {
  public int lengthOfLastWord(String s) {
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) == ' ') --i;
    final int lastIndex = i;
    while (i >= 0 && s.charAt(i) != ' ') --i;
    return lastIndex - i;
  }
}
