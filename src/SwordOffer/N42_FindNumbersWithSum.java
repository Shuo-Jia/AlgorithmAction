package SwordOffer;

import java.util.ArrayList;

public class N42_FindNumbersWithSum {
  /**
   * 输入一个递增排序的数组和一个数字S，
   * 在数组中查找两个数，是的他们的和正好是S，
   * 如果有多对数字的和等于S，输出两个数的乘积最小的。
   */
  public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    int low = 0;
    int high = array.length - 1;
    int curSum = -1;
    int minMulti = -1;
    boolean isFirstPair = false;//这个布尔标志只是指示当前是否找到第一对，然后把第一对的值和乘积值作为基准，
    // 展开接下来的比较。不然的话因为没有基准值，所以无法判断当前的乘积值是否最小
    //可以从下面的if语句看出此标志的必要性
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (low < high) {
      curSum = array[low] + array[high];
      if (curSum == sum) {//当发现等于sum的时候，
        if (!isFirstPair) {//如果这是第一对，则计算基准minMulti，同时存下来
          minMulti = array[low] * array[high];
          arrayList.add(array[low]);
          arrayList.add(array[high]);
          isFirstPair = true;
        } else if (array[low] * array[high] < minMulti) {//否则(不是第一对)，比较当前的乘机minMulti是否变小，变小则更新，否则维持原来的值
          arrayList.set(0, array[low]);
          arrayList.set(1, array[high]);
        }
        low++;
        high--;
      } else if (curSum < sum)
        low++;
      else if (curSum > sum)
        high--;
    }
    return arrayList;
  }

  public static void main(String[] args) {
    int[] array = new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1, 0,};
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList = new N42_FindNumbersWithSum().FindNumbersWithSum(array, -10);
  }
}
