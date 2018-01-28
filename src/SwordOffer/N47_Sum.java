package SwordOffer;

public class N47_Sum {
  /**
   * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
   */
  public int Sum_Solution(int n) {
    return sum(n);
  }

  private int sum(int n) {
    int res = n;
    int a = 1;
    boolean value = (n != 0) && a == (res += sum(n - 1));
    return res;
  }

  public static void main(String[] args) {
    int res = new N47_Sum().Sum_Solution(100);
  }
}
