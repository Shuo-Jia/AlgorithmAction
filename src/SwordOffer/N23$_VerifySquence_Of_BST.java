package SwordOffer;

public class N23$_VerifySquence_Of_BST {
  /**
   * 输入一个整数数组，判断该数组是不是某二叉搜索树的
   * 后序遍历的结果。如果是则输出Yes,否则输出No。假设
   * 输入的数组的任意两个数字都互不相同。
   * PS：这个和是否是二叉树有关系吗？好吧，起初我以为
   * 给你一个二叉搜索树序列，然后再给你一个数组，判断这个
   * 数组是不是这个二叉树的后续遍历！原来就是判断一个
   * 数组是否是一个合法的二叉搜索数后续遍历结果！
   * ---------------------------------算法：起始时末尾n为根节点，然后之前的数组一定能找到一个索引位k，
   * ---------------------------------则R[k0]< 根节点,R[k0+1] > 根节点；同时R[0~k] < R[n]，
   * ---------------------------------R[k+1~n-1]>R[n]再分别对分开的子列作同样的操作(运行时间：16ms
   * 占用内存：8716k)
   */
  public boolean VerifySquenceOfBST(int[] sequence) {
    if (sequence == null || sequence.length == 0)
      return false;
    return verify(0, sequence.length - 1, sequence);
  }

  /**
   * 8
   * 6            10
   * 5      7     9      11
   */

  private boolean verify(int start, int end, int[] sequence) {
    boolean l = true;
    boolean r = true;
    if (start == end)
      return true;
    int i = start;
    while (sequence[i] < sequence[end])
      i++;
    if (i > start && i < end) {
      l = verify(0, i - 1, sequence);
      r = verify(i, end, sequence);
    }
    for (int j = i; j < end; j++) {
      if (sequence[j] < sequence[end])
        return false;
    }
    return (l && r);
  }

  public static void main(String[] args) {
    boolean flag;
    int[] sequence0 = null;//空
    int[] sequence1 = new int[]{1};//根节点
    int[] sequence2 = new int[]{5, 6, 8};//左子树
    int[] sequence3 = new int[]{11, 10, 8};//右子树
    int[] sequence4 = new int[]{4, 5, 7, 6, 9, 12, 11, 10, 8};//全子树
    int[] sequence5 = new int[]{7, 4, 6, 5};
    flag = new N23$_VerifySquence_Of_BST().VerifySquenceOfBST(sequence4);
  }
}
