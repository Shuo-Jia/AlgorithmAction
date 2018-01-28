package SwordOffer;

public class N49_StrToInt {
  /**
   * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
   * 数值为0或者字符串不是一个合法的数值则返回0
   */
  public int StrToInt(String str) {
    if (str == null || str.length() == 0)
      return 0;
    double res = 0;
    int length = str.length();
    for (int i = 0; i < str.length(); i++) {
      if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
        continue;
      }
      if ((47 >= str.charAt(i) || str.charAt(i) >= 58))
        return 0;
      double j = (str.charAt(i) - 48) * Math.pow(10, (length - i - 1));
      res += (str.charAt(i) - 48) * Math.pow(10, (length - i - 1));
    }
    if (str.charAt(0) == '-')
      return (int) -res;
    else {
      return (int) res;
    }
  }

  public void test() {
    char a = '4';
    int b1 = a - 48;
  }

  public static void main(String[] args) {
    int res = new N49_StrToInt().StrToInt("-2147483648");
  }
}
