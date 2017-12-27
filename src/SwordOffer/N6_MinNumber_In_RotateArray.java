package SwordOffer;

public class N6_MinNumber_In_RotateArray {
  /**
   * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
   * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如
   * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：
   * 给出的所有元素都大于0，若数组大小为0，请返回0。
   * <p>
   * 个人疑问：这不就是排序吗？别管旋转与否都是一个数组，然后找最小值不就是？
   */
  public int minNumberInRotateArray(int[] array) {
    if (array.length == 0)
      return 0;
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1])
        return array[i + 1];
    }
    return array[0];
  }

  public int minNumberInRotateArrayPlus(int[] array) {
    if (array.length == 0)
      return 0;
    int left = 0;
    int right = array.length - 1;
    int middle = 0;
    while (left < right) {
      if (right - left == 1) {
        middle = right;
        break;
      }
      middle = (left + right) / 2;
      if (array[left] <= array[middle])
        left = middle;
      if (array[right] >= array[middle])
        right = middle;
    }
    return array[middle];
  }

  public static void main(String[] args) {
    int[] array = new int[]{3,4,5,1,2};
    int min = new N6_MinNumber_In_RotateArray().minNumberInRotateArray(array);
    int minPlus = new N6_MinNumber_In_RotateArray().minNumberInRotateArrayPlus(array);
  }
}
