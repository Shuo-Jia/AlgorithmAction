package SwordOffer;

public class N30_FindGreatestSumOfSubArray {
  /**
   * 一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，要求该连续子数组中各元素的和最大，
   * 这个连续子数组便被称作最大连续子数组。比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为
   * {5,2,-1,2}，最大连续子数组的和为5+2-1+2=8。
   * -----------------------------算法1：以每个点开始然后求该点作为起始点的最大子数组（略）
   * -----------------------------算法2：分治法（归并法），该算法并非最优，但是作为一个重要
   * -----------------------------------的算法思想，很有必要学习！最大的子数列包含分治后的左子列、
   * -----------------------------------右子列、跨子列，当递归到最后只剩一个元素后开始退栈，则该
   * -----------------------------------元素所属的上述三类子数列分别是左元素、右元素、总元素，再
   * -----------------------------------退栈的时候就是比较出最大子数列的时候，继续递归！所以最终
   * -----------------------------------计算的只是跨子列的大小！
   * -----------------------------算法3：线性数组法，优解！
   * -----------------------------算法4：线性规划法，优解！需要学习此算法思想！
   */

  public int FindGreatestSumOfSubArray(int[] array) {
    int to = array.length - 1;
    //return getMaxofSub_1(array, 0, to);
    return getMaxofSub_2(array, array.length);
  }

  /**
   * 算法1
   */
  private int getMaxofSub_1(int[] array, int from, int to) {
    if (from == to)
      return array[from];
    int mid = (from + to) / 2;
    int left = getMaxofSub_1(array, from, mid);
    int right = getMaxofSub_1(array, mid + 1, to);

    //计算跨子列
    //1.包含分割点的左侧的最大值
    int borLeft = 0;
    int maxBorLeft = array[mid];
    for (int i = mid; i >= from; i--) {
      borLeft = borLeft + array[i];
      if (borLeft > maxBorLeft)
        maxBorLeft = borLeft;
    }

    //2.分割点右侧（包含分割点右侧第一个数据）最大值
    int borRight = 0;
    int maxBorRight = array[mid + 1];
    for (int i = mid + 1; i <= to; i++) {
      borRight = borRight + array[i];
      if (borRight > maxBorRight)
        maxBorRight = borRight;
    }

    //3.包含分割点的最大值
    int bor = maxBorLeft + maxBorRight;

    return Math.max(Math.max(left, right), bor);
  }

  /**
   * 算法2
   */
  private int getMaxofSub_2(int[] array, int length) {
    int j = 0;
    int max = array[0];
    int cur = 0;
    for (int i = 0; i < length; i++) {
      cur += array[i];
      if (cur >= max)
        max = cur;
      if (cur < 0)
        cur = 0;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] array = new int[]{2, 4, -7, 5, 2, -1, 2, -4, 3};
    int[] array1 = {-2, -3, -1, -12};
    int max = new N30_FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array1);
  }
}
