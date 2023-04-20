package ca.t.demo.java;

class Solution0013v1 {
  public int romanToInt(String s) {
    int ret = 0;
    int[] roman = new int[128];

    roman['I'] = 1;
    roman['V'] = 5;
    roman['X'] = 10;
    roman['L'] = 50;
    roman['C'] = 100;
    roman['D'] = 500;
    roman['M'] = 1000;

    for (int i = 0; i + 1 < s.length(); ++i)
      if (roman[s.charAt(i)] < roman[s.charAt(i + 1)]) ret -= roman[s.charAt(i)];
      else ret += roman[s.charAt(i)];

    return ret + roman[s.charAt(s.length() - 1)];
  }
}
