package SwordOffer;

public class N40_FindNumsAppearOnce {
  /**
   * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
   * 请写程序找出这两个只出现一次的数字。
   */
  public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    if (array == null || array.length <= 4) {
      num1[0] = -1;
      num2[0] = -1;
    }
    int result = 0;
    num1[0] = 0;
    num2[0] = 0;
    for (int i : array) {
      result ^= i;
    }
    int index = findFirstIndexOf1(result);
    for (int i : array) {
      if (is1Ofindex(i, index))
        num1[0] ^= i;
      else
        num2[0] ^= i;
    }
  }

  private int findFirstIndexOf1(int num) {
    int index = 0;
    while ((num & 1) == 0 && index < 32) {
      num = num >> 1;
      index++;
    }
    return index;
  }

  private boolean is1Ofindex(int num, int index) {
    int temp = 1 << index;
    if ((num & temp) == 0)
      return false;
    return true;
  }

  private void test() {
    int a = 1 ^ 4;
    int a1 = 10;
    int b = 15;
    int c = 13;
    int d = 15;
    int e = 10;
    int g = 14;
    int h = 12;
    int i = 12;
    int f1 = a ^ b;
    int f2 = f1 ^ c;
    int f3 = f2 ^ d;
    int f4 = f3 ^ e;
    int f5 = f4 ^ g;
    int f6 = f5 ^ h;
    int f7 = f6 ^ i;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6};
    int[] num1 = new int[1];
    int[] num2 = new int[1];
    new N40_FindNumsAppearOnce().FindNumsAppearOnce(array, num1, num2);
  }
}

