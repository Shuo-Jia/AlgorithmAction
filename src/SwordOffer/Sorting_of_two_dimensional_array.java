package SwordOffer;

public class Sorting_of_two_dimensional_array {
  /**
   * 在一个二维数组中，每一行都按照从左到右递增的顺
   * 序排序，每一列都按照从上到下递增的顺序排序。请
   * 完成一个函数，输入这样的一个二维数组和一个整数，
   * 判断数组中是否含有该整数。
   *
   * 2  5  7  9  10 45
   * 3  8  9  11 15 50
   * 8  10 12 15 20 60
   */

  /**
   * 个人思路：（1）先查找数据所在的对角线数据的范围，然后
   * 循环查找，选择合适的查找基础算法--------》错：因为二
   * 维数组并不是对称的；
   * （2）是否可以把整个查找抽象成某个基本查找算法的模型？
   * <p>
   * 参考方法：从左下角开始
   */
  private static boolean find(int target, int[][] array) {
    //get the length
    int x = array.length - 1;
    int y = array[0].length - 1;

    int i = 0;
    while (x >= 0 && i <= y) {
      if (target > array[x][i]) {
        i++;
      } else if (target < array[x][i]) {
        x--;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] arrays1 = {{2, 5, 7, 9, 10, 45}, {3, 8, 9, 11, 15, 50}, {8, 10, 12, 15, 20, 60}};
    int[][] arrays2 = {};
    boolean flag = find(11,arrays1);
  }
}
