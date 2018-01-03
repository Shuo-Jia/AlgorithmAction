package SwordOffer;

import java.util.ArrayList;

public class N19_printMatrix {
  /**
   * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
   * 例如，如果输入如下矩阵：
   * 1  2  3  4
   * 5  6  7  8
   * 9  10 11 12
   * 13 14 15 16
   * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
   * 输出的顺序为
   * （00）（01）（02）（03）
   * （13）（23）（33）
   * （32）（31）（30）
   * （20）（10）
   * （11）（12）
   * （22）（21）
   * <p>
   * 每个点有四条方向：上下左右，但是存在两种情况：一个越界，一个已经遍历！类似于路径规划，
   * 凡是走过的点都不要走就行了！错！15可以14也可以11是如何判断的？
   *
   没有任何巧妙的算法，就是直接（右循环、下循环、左循环、上循环）这样的模式一直打印！
   这个相当于路径规划的问题，每访问一个节点就记录下来，下次遍历访问的时候，如果发现
   已经当前路径访问过了，就直接跳出来进入下一路径！注意不要越界，调试的时候出现最多
   的就是越界问题！（运行时间：31ms 占用内存：8796k）
   */
  public ArrayList<Integer> printMatrix(int[][] matrix) {
    int x_length = matrix.length;
    int y_length = matrix[0].length;
    int i = -1;
    int j = -1;
    boolean[][] flag = new boolean[x_length][y_length];
    ArrayList<Integer> arrayList = new ArrayList<>();
    while ((arrayList.size()) != (x_length * y_length )) {
      for (j++,i++;j < y_length && !flag[i][j];j++) {
        arrayList.add(matrix[i][j]);
        flag[i][j] = true;
      }

      for (i++,j--;i < x_length && !flag[i][j];i++) {
          arrayList.add(matrix[i][j]);
          flag[i][j] = true;
        }

      for (j--,i--; j >= 0 && !flag[i][j]; j--) {
        arrayList.add(matrix[i][j]);
        flag[i][j] = true;
      }

      for (i--,j++; i >= 0 && !flag[i][j]; i--) {
        arrayList.add(matrix[i][j]);
        flag[i][j] = true;
      }
    }
    return arrayList;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    new N19_printMatrix().printMatrix(matrix);
  }
}
