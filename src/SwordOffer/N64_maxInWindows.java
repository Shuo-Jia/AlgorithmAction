package SwordOffer;

import java.util.*;

public class N64_maxInWindows {
  /**
   * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
   * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
   * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
   * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
   * {2,[3,4,2],6,2,5,1}，{2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
   * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
   */

  public ArrayList<Integer> maxInWindows(int[] num, int size) {
    int i = 0;
    int j = 0;
    ArrayList<Integer> sortTemp = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    if (num == null || num.length < size)
      return arrayList;
    while (i < size) {
      sortTemp.add(num[i]);
      i++;
    }
    Collections.sort(sortTemp);
    int Max = sortTemp.get(sortTemp.size() - 1);
    arrayList.add(Max);
    while (i < num.length - 1) {
      j++;
      i = j + size - 1;
      if (num[j - 1] != Max) {
        if (num[i] < Max) {
          arrayList.add(Max);
        } else {
          Max = num[i];
          arrayList.add(Max);
        }
      } else {
        int m = j;
        int n = 0;
        while (m <= i) {
          sortTemp.set(n, num[m]);
          m++;
          n++;
        }
        Collections.sort(sortTemp);
        Max = sortTemp.get(sortTemp.size() - 1);
        arrayList.add(Max);
      }
    }
    return arrayList;
  }

  public static void main(String[] args) {
    int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList = new N64_maxInWindows().maxInWindows(num, 3);
  }
}
