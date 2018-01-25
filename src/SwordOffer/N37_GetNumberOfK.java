package SwordOffer;

public class N37_GetNumberOfK {
  /**
   * 统计一个数字在排序数组中出现的次数.
   * ---------------------算法：使用二分法进行遍历，直到遍历出来数字是k且左边没有k，遍历出来的
   * ---------------------------数字是k且右边不再是k。这两个位置之差+1就是结果！
   */
  public int GetNumberOfK(int[] array, int k) {
    int firstK = getFirstK(array, 0, array.length - 1, k);
    int lastK = getLastK(array, 0, array.length - 1, k);
    if (firstK == -1 && lastK == -1)
      return 0;
    return lastK - firstK + 1;
  }

  private int getFirstK(int[] array, int begin, int end, int k) {
    while (begin <= end) {
      int mid = (begin + end) / 2;
      if (array[mid] == k && (mid == 0 || array[mid - 1] != k))
        return mid;
      if (array[mid] < k) {
        begin = mid + 1;
      } else if (array[mid] >= k) {
        end = mid - 1;
      }
    }
    return -1;
  }

  private int getLastK(int[] array, int begin, int end, int k) {
    while (begin <= end) {
      int mid = (begin + end) / 2;
      if (array[mid] == k && (mid == array.length - 1 || array[mid + 1] != k))
        return mid;
      if (array[mid] <= k) {
        begin = mid + 1;
      } else if (array[mid] > k) {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
    int count = new N37_GetNumberOfK().GetNumberOfK(array, 0);
  }
}
