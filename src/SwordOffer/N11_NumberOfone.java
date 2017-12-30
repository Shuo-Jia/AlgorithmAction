package SwordOffer;

public class N11_NumberOfone {
  /**
   * 输入一个整数，输出该数二进制表示中1的个数。
   * 其中负数用补码表示。
   */

  public int NumberOf1(int n) {
    //转换成二进制后，从右边数n的第一个为1的位置对应的n-1的位置一定是0，所以n&n-1可以把n的
    //右数第一个1位清除，档把所有1位清楚后就变成了0，也就计算出了1的个数。
    int c;
    for(c=0;n!=0;c++){
      n&=(n-1);
    }
    return c;
  }
  private void shift(int n, int n1, int n2, int n3){
    System.out.println(n+" "+Integer.toBinaryString(n));
    n1 = n1>>1;
    n2 = n2<<1;
    n3 = n3>>>1;
    System.out.println(n+"->"+n1+" "+Integer.toBinaryString(n1));
    System.out.println(n+"->"+n2+" "+Integer.toBinaryString(n2));
    System.out.println(n+"->"+n3+" "+Integer.toBinaryString(n3));
  }

  private void bitwise(int n, int n1, int m1){
    System.out.println(n+" "+Integer.toBinaryString(n));
    System.out.println(m1+" "+Integer.toBinaryString(m1));
    n1 = n1&m1;
    System.out.println(n+"->"+n1+" "+Integer.toBinaryString(n1));
  }

  public static void main(String[] args){
    //new N11_NumberOfone().shift(-10,-10,-10,-10);
    new N11_NumberOfone().bitwise(10,10,1);
  }

}
