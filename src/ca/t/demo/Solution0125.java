package ca.t.demo;

class Solution0125v1 {
  public boolean isPalindrome(String s) {
    int leftSide = 0;
    int rightSide = s.length() - 1;
    while (leftSide < rightSide) {
      while (leftSide < rightSide && !Character.isLetterOrDigit(s.charAt(leftSide))) ++leftSide;
      while (leftSide < rightSide && !Character.isLetterOrDigit(s.charAt(rightSide))) --rightSide;
      if (Character.toLowerCase(s.charAt(leftSide)) != Character.toLowerCase(s.charAt(rightSide))) return false;
      ++leftSide;
      --rightSide;
    }
    return true;
  }
}
