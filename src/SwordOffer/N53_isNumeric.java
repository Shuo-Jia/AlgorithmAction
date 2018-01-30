package SwordOffer;

public class N53_isNumeric {
  /**
   * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
   * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
   * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
   */
  public boolean isNumeric(char[] str) {
    int[] e_E_pointOfcount = new int[3];
    return Number(str, 0, e_E_pointOfcount);
  }

  private boolean Number(char[] str, int i, int[] count) {
    if (str[i] == '+' || str[i] == '-') {
      if (i + 1 < str.length && ((47 < str[i + 1] && str[i + 1] < 58) || str[i + 1] == '.'))
        return Number(str, i + 1, count);
      else
        return false;
    } else if (47 < str[i] && str[i] < 58) {
      if (i == str.length - 1)
        return true;
      else if ((47 < str[i + 1] && str[i + 1] < 58) || str[i + 1] == 'e' || str[i + 1] == 'E' || str[i + 1] == '.')
        return Number(str, i + 1, count);
      else
        return false;
    } else if (str[i] == 'e') {
      count[0] = count[0] + 1;
      if (count[0] == 1 && i + 1 < str.length && ((47 < str[i + 1] && str[i + 1] < 58) || str[i + 1] == '-' || str[i + 1] == '+'))
        return Number(str, i + 1, count);
      else
        return false;
    } else if (str[i] == 'E') {
      count[1] = count[1] + 1;
      if (count[1] == 1 && i + 1 < str.length && ((47 < str[i + 1] && str[i + 1] < 58) || str[i + 1] == '-' || str[i + 1] == '+'))
        return Number(str, i + 1, count);
      else
        return false;
    } else if (str[i] == '.') {
      count[2] = count[2] + 1;
      if ((count[2] == 1 && count[0] == 0 && count[1] == 0) && i + 1 < str.length && (47 < str[i + 1] && str[i + 1] < 58))
        return Number(str, i + 1, count);
      else
        return false;
    } else
      return false;
  }

  public static void main(String[] args) {
    char[] number = new char[]{'+', '1', 'e', '3'};
    boolean flag = new N53_isNumeric().isNumeric(number);
  }
}
