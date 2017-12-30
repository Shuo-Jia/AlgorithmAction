package SwordOffer;

public class N13_reOrderArray {
  /**
   * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
   * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
   * ————————>如果是偶数就放在上一个偶数的后边，奇数同样的道理！错！
   * ————————>取数组缓存在重组吧！（运行时间：18ms；占用内存：8736k）
   * ————————>这个感觉好像快排，只不过那个是比较好放在左右两边，这个是奇偶后放在两边！但是这样相对顺序变了！
   */
  public void reOrderArray(int[] array) {
    int p = 0, q = 0;
    int length = array.length;
    int[] ptemp = new int[length];
    int[] qtemp = new int[length];
    for (int i = 0; i < length; i++) {
      if (array[i] % 2 == 0) {
        ptemp[p] = array[i];
        p++;
      } else if (array[i] % 2 != 0) {
        qtemp[q] = array[i];
        q++;
      }
    }

    for (int i = 0; q < length; i++) {
      qtemp[q] = ptemp[i];
      q++;
    }
    for(int i = 0;i<length;i++){
      array[i] = qtemp[i];
    }
  }


  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 4, 6, 5, 7};
    new N13_reOrderArray().reOrderArray(array);
  }
}
