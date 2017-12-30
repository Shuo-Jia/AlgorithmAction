package SwordOffer;

public class N12_Base_power_Exp {
  /**
   * 给定一个double类型的浮点数base和int类型的整数exponent。
   * 求base的exponent次方。
   */
  public double Power(double base, int exponent) {
    int i = 1;
    double res = 1;
    if (exponent >= 0) {
      while (i <= exponent) {
        res = res * base;
        i++;
      }
      return res;
    }
    else{
      exponent = -exponent;
      while (i <= exponent) {
        res = res * base;
        i++;
      }
      return 1/res;
    }
  }

  public static void main(String[] args) {
    double res;
    N12_Base_power_Exp n12_base_power_exp = new N12_Base_power_Exp();
    res = n12_base_power_exp.Power(2.0, -3);
  }
}
