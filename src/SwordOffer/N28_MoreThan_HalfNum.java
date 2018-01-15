package SwordOffer;

import java.util.HashMap;

public class N28_MoreThan_HalfNum {
  /**
   * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长
   * 度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的
   * 一半，因此输出2。如果不存在则输出0。
   */
  public int MoreThanHalfNum_Solution(int[] array) {
    if (array == null || array.length == 0)
      return 0;
    if (array.length == 1)
      return array[0];
    int countValue = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (!hashMap.containsKey(array[i]))
        hashMap.put(array[i], 1);
      else {
        countValue = hashMap.get(array[i]);
        hashMap.put(array[i], ++countValue);
        if (countValue > array.length / 2)
          return array[i];
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] array = new int[]{5};
    int arrayNumber = new N28_MoreThan_HalfNum().MoreThanHalfNum_Solution(array);
  }
}
