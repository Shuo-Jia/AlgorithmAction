package SwordOffer;

import java.util.ArrayList;

public class N29_Get_K_LeastNumbers {
  /**
   * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字
   * 则最小的4个数字是1,2,3,4.
   * ------------------算法：就是简单的排序，就看选择哪种排序方法！
   * ------------------注意这个排序方法必须能在k词排序中确定前k个数据
   * ------------------满足这个条件的有冒泡、选择、堆排序！其中快排虽然
   * ------------------能够确定某个位置的数据，但是不能按照顺序确定！每次
   * ------------------只能把枢轴值放在正确的位置上！从时间复杂度看来，
   * ------------------选择堆排序具有较好的效果，排序k此即可！其实任何一种排序
   * ------------------算法都行，待全部排序完成后遍历前K值就行了，但是明显增加了
   * ------------------时间复杂度
   */

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    int length = input.length;
    ArrayList<Integer> arrayList = new ArrayList<>();
    if (input == null || input.length == 0 || k == 0 || k > input.length)
      return arrayList;
    for (int i = 0; i < k; i++) {
      buildHeap_Small(input, length);
      swap(input, 0, length - 1);
      arrayList.add(input[length - 1]);
      length--;
    }
    return arrayList;
  }

  private void buildHeap_Small(int[] input, int length) {
    for (int pos = (length / 2) - 1; pos >= 0; pos--) {
      if (pos * 2 + 1 < length && input[pos * 2 + 1] < input[pos])
        swap(input, pos * 2 + 1, pos);
      if (pos * 2 + 2 < length && input[pos * 2 + 2] < input[pos])
        swap(input, pos * 2 + 2, pos);
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    int[] input = new int[]{1, 2};
    new N29_Get_K_LeastNumbers().GetLeastNumbers_Solution(input, 2);
  }
}
