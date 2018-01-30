package SwordOffer;

public class N52_match {
  /**
   * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
   * 模式中的字符'.'表示任意一个字符，而'*'表示它前
   * 面的字符可以出现任意次（包含0次）。 在本题中，
   * 匹配是指字符串的所有字符匹配整个模式。例如，字
   * 符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与
   * "aa.a"和"ab*a"均不匹配
   */
  public boolean match(char[] str, char[] pattern) {
    if (str == null || pattern == null)
      return false;
    return match_i2j(0, 0, str, pattern);
  }

  private boolean match_i2j(int i, int j, char[] str, char[] pattern) {
    if (i == str.length && j == pattern.length)
      return true;
    if (j == pattern.length && i != str.length)
      return false;
    if (j + 1 < pattern.length && pattern[j + 1] == '*') {
      if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.'))
        return (match_i2j(i, j + 2, str, pattern) || match_i2j(i + 1, j, str, pattern) || match_i2j(i + 1, j + 2, str, pattern));
      else
        return match_i2j(i, j + 2, str, pattern);
    }

    if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.'))
      return match_i2j(i + 1, j + 1, str, pattern);
    return false;
  }


  public static void main(String[] args) {
    char[] str = {};
    char[] pattern = {'.', '*'};
    boolean flag = new N52_match().match(str, pattern);
    //boolean zero = new N52_match().Match_Zerochar(0, pattern);
  }
}
