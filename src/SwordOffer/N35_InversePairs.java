package SwordOffer;

public class N35_InversePairs {
  /**
   * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
   * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
   * ---------------------------算法1：不知道为何算法1牛客始终通过不了！
   * ---------------------------算法2：还是归并吧！
   */
  public int InversePairs(int[] array) {
    //return inversePairsbyCommon(array);
    return inversePairbyMsort(array, 0, array.length - 1);
  }

  private int inversePairsbyCommon(int[] array) {
    int count = 0;
    if (array == null || array.length == 0 || array.length == 1)
      return -1 % 1000000007;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          count++;
          if (count >= 1000000007)
            count = count % 1000000007;
        }
      }
    }
    return count % 1000000007;
  }

  private int inversePairbyMsort(int[] array, int begin, int end) {
    if (begin == end)
      return 0;
    int mid = (begin + end) / 2;
    int left = inversePairbyMsort(array, begin, mid);
    int right = inversePairbyMsort(array, mid + 1, end);
    int count = merge(array, begin, mid, end);
    return left + right + count;
  }

  private int merge(int[] array, int begin, int mid, int end) {
    int mid2 = mid + 1;
    int[] temp = new int[end - begin + 1];
    int cur = 0;
    int count = 0;
    int i = begin;
    while (begin <= mid && mid2 <= end) {
      if (array[begin] > array[mid2]) {
        temp[cur++] = array[mid2++];
        count += mid - begin + 1;
        if (count > 1000000007)
          count = count % 1000000007;
      } else {
        temp[cur++] = array[begin++];
      }
    }

    while (begin <= mid) {
      temp[cur++] = array[begin++];
    }
    while (mid2 <= end) {
      temp[cur++] = array[mid2++];
    }

    //把缓存复制到原数组
    cur = 0;
    while (i <= end) {
      array[i++] = temp[cur++];
    }

    return count;
  }


  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
    int mod = new N35_InversePairs().InversePairs(array);
  }
}
