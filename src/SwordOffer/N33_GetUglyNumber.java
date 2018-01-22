package SwordOffer;

public class N33_GetUglyNumber {
  /**
   * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
   * 因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
   */
  public int GetUglyNumber_Solution(int index) {
    int[] array = new int[index];
    array[0] = 1;
    int nextIndex = 1;
    int i_2 = 0;
    int i_3 = 0;
    int i_5 = 0;
    while (nextIndex < index) {
      array[nextIndex] = Math.min(Math.min(array[i_2] * 2, array[i_3] * 3), array[i_5] * 5);
      while (array[i_2] * 2 <= array[nextIndex])
        i_2++;
      while (array[i_3] * 3 <= array[nextIndex])
        i_3++;
      while (array[i_5] * 5 <= array[nextIndex])
        i_5++;
      nextIndex++;
    }
    return array[index - 1];
  }

  public static void main(String[] args) {
    int ugly = new N33_GetUglyNumber().GetUglyNumber_Solution(10);
  }
}
