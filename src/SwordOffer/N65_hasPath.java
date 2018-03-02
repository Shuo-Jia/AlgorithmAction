package SwordOffer;

public class N65_hasPath {
  /**
   * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
   * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
   * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再
   * 进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"
   * 的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵
   * 中的第一行第二个格子之后，路径不能再次进入该格子。
   */
  public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    if (matrix == null || matrix.length == 0 || str == null || str.length == 0 || str.length > matrix.length)
      return false;
    boolean[] isVisited = new boolean[(rows + 1) * (cols + 1)];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (find(matrix, i, rows, j, cols, str, 0, isVisited))
          return true;
      }
    }
    return false;
  }

  private boolean find(char[] matrix, int row, int rows, int col, int cols, char[] str, int index, boolean[] isVisited) {
    if (index == str.length)
      return true;
    boolean hasPath = false;
    if ((row >= 0 && row < rows) && (col >= 0 && col < cols)
            && (matrix[cols * row + col] == str[index] && !isVisited[cols * row + col])) {
      index++;
      isVisited[cols * row + col] = true;
      hasPath = find(matrix, row - 1, rows, col, cols, str, index, isVisited) ||
              find(matrix, row + 1, rows, col, cols, str, index, isVisited) ||
              find(matrix, row, rows, col - 1, cols, str, index, isVisited) ||
              find(matrix, row, rows, col + 1, cols, str, index, isVisited);
      if (!hasPath) {
        index--;
        isVisited[row * cols + col] = false;
      }
    }
    return hasPath;
  }

  public static void main(String[] args) {
    char[] matrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
    char[] str = new char[]{'b', 'c', 'c', 'e', 'd'};
    boolean hasPath = new N65_hasPath().hasPath(matrix, 3, 4, str);
  }
}
