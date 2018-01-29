package SwordOffer;

public class N51_multiply {
  /**
   * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
   * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
   * 不能使用除法。
   * ------------------算法1：请当做不能使用乘除法的算法，否则实在是太麻烦了！
   * ------------------算法2：动态规划法：每次次循环计算出A[i]之前的乘积值并赋值到B[i-1]，
   * 则B[i]=B[i-1]*A[i-1]（这样计算并不需要每次都要把所有的A[0~i]值乘一遍，而是利用上一次的乘
   * 积值作为下一次的因数）；然后再计算A[i]之后的乘积值。两者相乘就是除了A[i]之后的乘积值
   */
  public int[] multiply(int[] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }

    double res = 0;
    int m = 0;
    int count = 0;
    int[] B = new int[A.length];
    //如果发现有0值，则该索引位等于其他位的乘积，其他索引位为0（即B[i]默认值）;同时统计负值的个数
    while (m < A.length) {
      if (A[m] != 0) {
        if (A[m] < 0)
          count++;
        m++;
      } else {
        B[m] = 1;
        for (int i = 0; i < A.length; i++) {
          if (i != m) {
            B[m] *= A[i];
          }
        }
        return B;
      }
    }

    //统计负值个数的（奇偶性）
    count = count % 2;

    for (int Adata : A) {
      res += Math.log(Math.abs(Adata));
    }

    for (int i = 0; i < A.length; i++) {
      if (count == 0) {
        if (A[i] < 0)
          B[i] = -(int) (Math.pow(Math.E, res - Math.log(-A[i])) + 0.5);
        else
          B[i] = (int) (Math.pow(Math.E, res - Math.log(A[i])) + 0.5);
      } else {
        if (A[i] < 0)
          B[i] = (int) (Math.pow(Math.E, res - Math.log(-A[i])) + 0.5);
        else
          B[i] = -(int) (Math.pow(Math.E, res - Math.log(A[i])) + 0.5);
      }
    }
    return B;
  }

  public int[] multiplyPlus(int[] A) {
    int length = A.length;
    int[] B = new int[length];
    if (length != 0) {
      B[0] = 1;
      for (int i = 1; i < length; i++) {
        B[i] = B[i - 1] * A[i - 1];
      }

      int temp = 1;
      for (int j = length - 2; j >= 0; j--) {
        temp *= A[j + 1];
        B[j] *= temp;
      }
    }
    return B;
  }


  public static void main(String[] args) {
    int[] A = new int[]{1, 2, 0, 3};
    int[] B = new N51_multiply().multiply(A);
  }
}
