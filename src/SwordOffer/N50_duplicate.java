package SwordOffer;

import java.util.ArrayList;

public class N50_duplicate {
  /**
   * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
   * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个
   * 重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是
   * 第一个重复的数字2
   */
  public boolean duplicate(int numbers[], int length, int[] duplication) {
    if (numbers == null || numbers.length == 0) {
      duplication[0] = -1;
      return false;
    }
    length = numbers.length;
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (arrayList.contains(numbers[i])) {
        duplication[0] = numbers[i];
        return true;
      }
      arrayList.add(numbers[i]);
    }
    duplication[0] = -1;
    return false;
  }

  public static void main(String[] args) {
    int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
    int[] deplication = new int[1];
    boolean flag = new N50_duplicate().duplicate(array, 7, deplication);
  }
}
